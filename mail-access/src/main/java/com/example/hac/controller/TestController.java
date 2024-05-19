package com.example.hac.controller;

import com.example.hac.mapper.TestMapper;
import com.example.hac.pojo.Registry;
import com.example.hac.result.Result;
import com.example.hac.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.regex.Pattern;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private TestMapper testMapper;


    @Value("${jedis-redis.host}")
    private String host;

    @Value("${jedis-redis.port}")
    private int port;

    /**
     * 获取验证码 并存入redis  以便于在注册时进行快速验证
     */
    @PostMapping(value = "/sendcode")
    public Result sendCode(@RequestBody Map<String, String> map) {
        String email = map.get("email");

        // 先检验邮箱是否已经被注册
        Registry registry = testMapper.selectByEmail(email);
        log.info("注册前先检验邮箱是否已经被注册,数据库中查询" + registry);

        if (registry != null) {
            return Result.error("邮箱已经被注册");
        }

        // 发过一次 防止重复发验证码
        Jedis jedis = new Jedis(host, port);
        jedis.auth("sh1314..");
        if (jedis.get(email) != null) {
            return Result.error("请勿重复发送验证码");
        }
        jedis.close();

        testService.sendCode(email);
        return Result.success();
    }


    /**
     * 注册
     */
    @PostMapping(value = "/register")
    public Result register(@RequestBody Registry registry) {
        // 验证邮箱  密码合法性
        if (registry.getPassword().length() < 6) {
            return Result.error("密码长度不能小于6位");
        }
        if (registry.getPassword().length() > 30) {
            return Result.error("密码长度不能大于30位");
        }

        if (!isValidEmail(registry.getEmail())) {
            return Result.error("邮箱格式错误");
        }

        Jedis jedis = new Jedis(host, port);
        jedis.auth("sh1314..");
        // 要处理查不到的情况 防止空指针
        String code = jedis.get(registry.getEmail());
        if (code == null) {
            return Result.error("邮箱无效或验证码已过期");
        }
        if (code.equals(registry.getVerificationCode())) {
            // 登陆成功删除验证码
            jedis.del(registry.getEmail());
            jedis.close();

            // 数据存入数据库
            // 密码加密存储
            //registry.setPassword(hashPassword(registry.getPassword()));
            registry.setCreateTime(LocalDateTime.now());
            testMapper.saveRegistry(registry);

            return Result.success();

        } else {
            return Result.error("验证码错误");
        }
    }

    /**
     * 登录
     */
    @PostMapping(value = "/login")
    public Result login(@RequestBody Registry registry) {
        // 验证邮箱  密码合法性
        if (registry.getPassword().length() < 6) {
            return Result.error("密码长度不能小于6位");
        }
        if (registry.getPassword().length() > 30) {
            return Result.error("密码长度不能大于30位");
        }


        if (!isValidEmail(registry.getEmail())) {
            return Result.error("邮箱格式错误");
        }

        // 验证是否注册了
        Registry one = testMapper.selectByEmail(registry.getEmail());
        System.out.println(one);
        if (one == null) {
            return Result.error("用户不存在");
        }

        // 验证密码
        if (one.getPassword().equals(registry.getPassword())) {
            return Result.success();
        } else {
            return Result.error("密码错误");
        }
    }

    public String hashPassword(String password) {
        // 盐
        String salt = BCrypt.gensalt();

        return BCrypt.hashpw(password, salt);
    }

    // 验证密码
    public boolean verifyPassword(String password, String hashedPassword) {
        // 使用存储在数据库中的哈希值进行比较
        return BCrypt.checkpw(password, hashedPassword);
    }


    public boolean isValidEmail(String email) {
        String regexPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regexPattern, email);
    }

}
