package com.cxgedu.security.springboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YTF
 * 2019/12/9
 */
@RestController
public class LoginController {
    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=utf-8"})
    public String loginSuccess(){
        //提示具体用户名登录成功
        return getUsername()+"  登录成功！";
    }
    //获取当前用户信息
    private String getUsername(){
        String username = null;
        //当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取用户身份
        Object principal = authentication.getPrincipal();
        if(principal == null){
            username = "匿名";
        }
        if(principal instanceof org.springframework.security.core.userdetails.UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        }else {
            username = principal.toString();
        }
        return username;
    }

    /**
     * 测试资源r1
     * @return
     */
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=utf-8"})
    public String r1(){
        return  getUsername() + " 访问资源r1....";
    }

    /**
     * 测试资源r2
     * @return
     */
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=utf-8"})
    public String r2(){
        return getUsername() + " 访问资源r2....";
    }


}
