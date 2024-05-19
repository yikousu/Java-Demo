package com.yikousu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yikousu.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
