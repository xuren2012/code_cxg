package com.cxgedu.security.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YTF
 * 2019/12/7
 */
@RestController
public class LoginController {
    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=utf-8"})
    public String loginSuccess(){
        return " 登录成功！";
    }

    /**
     * 测试资源r1
     * @return
     */
    @GetMapping(value = "/r/r1",produces = {"text/plain;charset=utf-8"})
    public String r1(){
        return "访问资源r1....";
    }

    /**
     * 测试资源r2....
     * @return
     */
    @GetMapping(value = "/r/r2",produces = {"text/plain;charset=utf-8"})
    public String r2(){
        return "访问资源r2....";
    }
}
