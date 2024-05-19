package com.yikousu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yikousu.config.R;
import com.yikousu.mapper.EmployeeMapper;
import com.yikousu.pojo.Employee;
import com.yikousu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public R employee() {
        return R.success(JSON.toJSONString(employeeMapper.selectList(null)));
    }
}
