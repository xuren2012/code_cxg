package com.cxgedu.security.springmvc.service;

import com.cxgedu.security.springmvc.model.AuthenticationRequest;
import com.cxgedu.security.springmvc.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by YTF
 * 2019/12/5
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    /**
     * 用户认证，校验用户身份信息是否合法
     * @param authenticationRequest  用户认证请求，包括账号、密码
     * @return 认证成功的用户信息
     */
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {

        //校验参数是否为空
        if(authenticationRequest == null
           || StringUtils.isEmpty(authenticationRequest.getUsername())
           || StringUtils.isEmpty(authenticationRequest.getPassword())){
            throw new RuntimeException("帐号和密码不能为空");
        }
        //根据帐号查询数据库，在此模拟之
        UserDto user = getUserDto(authenticationRequest.getUsername());
        //判断用户是否存在
        if(user == null){
            throw new RuntimeException("该用户不存在！");
        }
        //校验密码
        if(!authenticationRequest.getPassword().equals(user.getPassword())){
            throw new RuntimeException("帐号或密码错误！");
        }
        //认证通过，返回用户认证信息
        return user;
    }
    //根据帐号查询用户信息
    private UserDto getUserDto(String userName) {
        return userMap.get(userName);
    }

    //用户信息
    private Map<String,UserDto> userMap = new HashMap<>();
    {
        Set<String> authorities1 = new HashSet<>();
        authorities1.add("p1"); //使其与/r/r1对应
        Set<String> authorities2 = new HashSet<>();
        authorities2.add("p2");//使其与/r/r2对应
        userMap.put("zhangsan",new UserDto("1010","zhangsan","123","张三","111111",authorities1));
        userMap.put("lisisi",new UserDto("1011","lisisi","456","李思思","222222",authorities2));
    }
}
