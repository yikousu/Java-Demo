package com.yikousu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "druginformation")//实体类映射到数据库表
public class Drug implements Serializable {
    //@TableField(value = "drugId") //实体类属性映射到数据库字段
    @TableId(type = IdType.AUTO)
    private Integer drugId;
    private String drugName;
    private String manufacturer;
    private Date productionDate;
    //保质期
    private Integer shelfLife;
    //药品用途
    private String drugUsage;
    private BigDecimal price;
    private Integer quantity;
    private String handler;
}
