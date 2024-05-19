package com.yikousu.controller;

import com.yikousu.config.R;
import com.yikousu.mapper.EmployeeMapper;
import com.yikousu.pojo.Employee;
import com.yikousu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查所有
     */
    @GetMapping(value = "/employee")
    public R employee(){
        return employeeService.employee();
    }

    /**
     * 根据id删除
     */
    @DeleteMapping(value="/employee/{id}")
    public R deleteById(@PathVariable("id")int id){
        employeeMapper.deleteById(id);
        return R.success("删除成功");
    }

    /**
     * 根据id修改
     */
    @PutMapping(value="/employee/{id}")
    public R updateById(@RequestBody Employee dto){
        employeeMapper.updateById(dto);
        return R.success("修改成功");
    }

    /**
     * 添加
     */
    @PostMapping(value="/employee")
    public R insert(@RequestBody Employee dto){
        employeeMapper.insert(dto);
        return R.success("添加成功");
    }
}
