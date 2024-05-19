package com.example.hac.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author <a href="https://github.com/yikousu">yikousu</a>
 * @date 2024/5/5 11:50
 */

@Data
public class Registry {
    private int id;
    private String email;
    private String password;
    private String verificationCode;
    private LocalDateTime createTime;
}
