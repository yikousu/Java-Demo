package com.yikousu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "outgoinginformation")
public class OutgoingInformation {
    @TableId(type = IdType.AUTO)
    private Integer outgoingId;
    private int drugId;
    private Date outgoingDate;
    private int outgoingQuantity;
}