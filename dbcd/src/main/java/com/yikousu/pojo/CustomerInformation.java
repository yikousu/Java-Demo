package com.yikousu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "customerinformation")
public class CustomerInformation implements Serializable {
    @TableId(value = "CustomerID",type = IdType.AUTO)
    @TableField(value = "CustomerID")
    private int customerId;
    @TableField(value = "Name")
    private String name;
    @TableField(value = "ContactInfo")
    private String contactInfo;
    @TableField(value = "PurchaseDate")
    private Date purchaseDate;
    @TableField(value = "PurchaseDrugID")
    private int purchaseDrugId;
    @TableField(value = "PurchaseDrugName")
    private String purchaseDrugName;
    @TableField(value = "PurchaseQuantity")
    private int purchaseQuantity;
}