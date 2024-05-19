package com.yikousu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "incominginformation")
public class IncomingInformation implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer incomingId;
    private int drugId;
    private Date incomingDate;
    private int incomingQuantity;
    private String storageLocation;
}