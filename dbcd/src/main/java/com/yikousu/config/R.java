package com.yikousu.config;

import lombok.Data;

import java.io.Serializable;

@Data
public class R<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private T data; //数据

    public static <T> R<T> success(T data) {
        R<T> r = new R<T>();
        r.data = data;
        r.code = 1;
        return r;
    }

    /**
     * static后面的<T>：表示在方法上声明泛型的固定写法
     * R<T>：方法的返回值，R带泛型
     */
    public static <T> R<T> error(String msg) {
        R<T> r = new R<T>();
        r.msg = msg;
        r.code = 0;
        return r;
    }
}
