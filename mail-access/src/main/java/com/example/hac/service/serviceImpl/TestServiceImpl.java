package com.example.hac.service.serviceImpl;

import com.example.hac.mapper.TestMapper;
import com.example.hac.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Random;

@Service
@Slf4j
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${jedis-redis.host}")
    private String host;

    @Value("${jedis-redis.port}")
    private int port;


    @Override
    public void sendCode(String email) {
        log.info("注册邮箱:"+email);
        SimpleMailMessage message = new SimpleMailMessage();

        //随机生成6位数验证码
        Random random = new Random();
        int code = 100000 + random.nextInt(90000);
        log.info("验证码:"+code);

        // 封装
        message.setFrom("hac1322@163.com");
        message.setTo(email);
        message.setSubject("登录验证 -- 您的一次性验证码");
        String text = "尊敬的用户，\n" +
                "\n" +
                "您正在进行邮箱验证操作。您的验证码是：" + code + ", 本验证码5分钟内有效，感谢您使用\n" +
                "\n" +
                "请将此验证码输入到相应的验证页面以完成验证。\n" +
                "\n" +
                "如果您未进行此操作，请忽略此邮件。\n" +
                "\n" +
                "感谢您使用我们的服务！\n" +
                "\n" +
                "祝您生活愉快！\n";
        message.setText(text);

        //发送邮箱
        mailSender.send(message);


        // 邮箱+验证码 存入redis
        Jedis jedis = new Jedis(host, port);
        jedis.auth("sh1314..");
        jedis.set(email, String.valueOf(code));
        jedis.expire(email, 60 * 5);//设置5min过期
        jedis.close();
    }
}
