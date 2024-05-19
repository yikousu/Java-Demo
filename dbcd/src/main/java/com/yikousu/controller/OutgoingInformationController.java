package com.yikousu.controller;

import com.alibaba.fastjson.JSON;
import com.yikousu.config.R;
import com.yikousu.mapper.IncomingInformationMapper;
import com.yikousu.mapper.OutgoingInformationMapper;
import com.yikousu.pojo.IncomingInformation;
import com.yikousu.pojo.OutgoingInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class OutgoingInformationController {
    @Autowired
    private OutgoingInformationMapper outgoingInformationMapper;
    /**
     * 查所有
     */
    @GetMapping(value = "/outgoinginformation")
    public R search(){
        return R.success(JSON.toJSONString(outgoingInformationMapper.selectList(null)));
    }

    /**
     * 根据id删除
     */
    @DeleteMapping(value="/outgoinginformation/{id}")
    public R deleteById(@PathVariable("id")int id){
        outgoingInformationMapper.deleteById(id);
        return R.success("删除成功");
    }

    /**
     * 根据id修改
     */
    @PutMapping(value="/outgoinginformation/{id}")
    public R updateById(@RequestBody OutgoingInformation dto){
        dto.setOutgoingDate(new Date());
        outgoingInformationMapper.updateById(dto);
        return R.success("修改成功");
    }

    /**
     * 添加
     */
    @PostMapping(value="/outgoinginformation")
    public R insert(@RequestBody OutgoingInformation dto){
        dto.setOutgoingDate(new Date());
        outgoingInformationMapper.insert(dto);
        return R.success("添加成功");
    }
}
