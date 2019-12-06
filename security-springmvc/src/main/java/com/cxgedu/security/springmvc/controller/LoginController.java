package com.cxgedu.security.springmvc.controller;

import com.cxgedu.security.springmvc.model.AuthenticationRequest;
import com.cxgedu.security.springmvc.model.UserDto;
import com.cxgedu.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by YTF
 * 2019/12/5
 */
@RestController
public class LoginController {
    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login",produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        session.setAttribute(UserDto.SESSION_USER_KEY,userDto);//实现会话功能
        return userDto.getUsername() + "登录成功！";
    }

    //退出登录
    @GetMapping(value = "/logout",produces = {"text/plain;charset=utf-8"})
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功。";
    }

    //获取资源1
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=utf-8"})
    public String r1(HttpSession session){
        String fullname = null;
        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(object == null){
            fullname = "匿名";
        }else{
            UserDto userDto = (UserDto)object;
            fullname = userDto.getFullname();
        }
        return fullname +"访问资源r1.";
    }

    //获取资源2
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=utf-8"})
    public String r2(HttpSession session){
        String fullname = null;
        Object object = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(object == null){
            fullname = "匿名";
        }else{
            UserDto userDto = (UserDto)object;
            fullname = userDto.getFullname();
        }
        return fullname +"访问资源r2.";
    }
}
