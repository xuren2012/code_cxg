package com.cxgedu.security.springmvc.service;

import com.cxgedu.security.springmvc.model.AuthenticationRequest;
import com.cxgedu.security.springmvc.model.UserDto;

/**
 * Created by YTF
 * 2019/12/5
 */
public interface AuthenticationService {
    /**
     * 用户认证
     * @param authenticationRequest  用户认证请求，包括账号、密码
     * @return   认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
