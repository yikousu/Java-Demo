package com.yikousu.controller;

import com.alibaba.fastjson.JSON;
import com.yikousu.config.R;
import com.yikousu.mapper.CustomerInformationMapper;
import com.yikousu.pojo.CustomerInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class CustomerInformationController {
    @Autowired
    private CustomerInformationMapper customerInformationMapper;

    @GetMapping(value = "/customerinformation")
    public R searchAll() {
        return R.success(JSON.toJSONString(customerInformationMapper.selectList(null)));
    }

    @DeleteMapping(value = "/customerinformation/{id}")
    public R deleteById(@PathVariable("id") int id) {
        customerInformationMapper.deleteById(id);
        return R.success("删除成功");
    }

    @PutMapping(value = "/customerinformation/{id}")
    public R updateById(@RequestBody CustomerInformation dto) {
        dto.setPurchaseDate(new Date());
        customerInformationMapper.updateById(dto);
        return R.success("更新成功");
    }

    @PostMapping("/customerinformation")
    public R insert(@RequestBody CustomerInformation dto ){
        dto.setPurchaseDate(new Date());
        customerInformationMapper.insert(dto);
        return R.success("添加成功");

    }

}
