package com.cxgedu.security.springmvc.model;

import lombok.Data;

/**
 * Created by YTF
 * 2019/12/5
 */
@Data
public class AuthenticationRequest {
    //认证请求参数
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
