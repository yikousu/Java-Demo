package com.yikousu.controller;

import com.alibaba.fastjson.JSON;
import com.yikousu.config.R;
import com.yikousu.mapper.IncomingInformationMapper;
import com.yikousu.pojo.Drug;
import com.yikousu.pojo.IncomingInformation;
import com.yikousu.service.IncomingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class IncomingInformationController {
    @Autowired
    private IncomingInformationService incomingInformationService;
    @Autowired
    private IncomingInformationMapper incomingInformationMapper;

    /**
     * 查所有
     */
    @GetMapping(value = "/incominginformation")
    public R search() {
        return R.success(JSON.toJSONString(incomingInformationMapper.selectList(null)));
    }

    /**
     * 根据id删除
     */
    @DeleteMapping(value = "/incominginformation/{id}")
    public R deleteById(@PathVariable("id") int id) {
        incomingInformationMapper.deleteById(id);
        return R.success("删除成功");
    }

    /**
     * 根据id修改
     */
    @PutMapping(value = "/incominginformation/{id}")
    public R updateById(@RequestBody IncomingInformation dto) {
        dto.setIncomingDate(new Date());
        incomingInformationMapper.updateById(dto);
        return R.success("修改成功");
    }

    /**
     * 添加
     */
    @PostMapping(value = "/incominginformation")
    public R insert(@RequestBody IncomingInformation dto) {
        dto.setIncomingDate(new Date());
        incomingInformationMapper.insert(dto);
        return R.success("添加成功");
    }

    /**
     * 根据id查库存剩余多少
     */
    @GetMapping(value = "/incominginformation/residuleById/{id}")
    public R residuleById(@PathVariable("id") int id) {
        IncomingInformation one = incomingInformationMapper.selectById(id);
        if (!ObjectUtils.isEmpty(one)) {
            return R.success(JSON.toJSONString(incomingInformationMapper.residuleById(id)));
        } else {
            return R.error("暂无此药品");
        }
    }
}
