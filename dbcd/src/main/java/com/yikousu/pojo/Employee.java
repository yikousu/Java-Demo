package com.yikousu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "employeeinformation")
public class Employee {
    @TableId(type = IdType.AUTO)
    private int employeeId;
    private String name;
    private String gender;
    private int age;
    private String education;
    private String position;
}