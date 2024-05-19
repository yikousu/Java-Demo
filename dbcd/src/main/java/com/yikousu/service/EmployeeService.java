package com.yikousu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yikousu.config.R;
import com.yikousu.pojo.Employee;

public interface EmployeeService extends IService<Employee> {
    R employee();

}
