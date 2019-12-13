package com.cxgedu.security.springboot.service;

import com.cxgedu.security.springboot.model.UserDto;
import com.cxgedu.security.springboot.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YTF
 * 2019/12/9
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;
    //根据账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //实现数据库查询--最终
        UserDto userDto = userDao.getUserByUsername(username);
        if(userDto == null){
            //如果用户查询不成功，返回null,由provider抛异常。
            return null;
        }
        //根据用户的id查询用户的权限
        List<String> permissions = userDao.findPermissionByUserId(userDto.getId());
        //把permissions 转换成数组
        String[] permissionsArray = new String[permissions.size()];
        permissions.toArray(permissionsArray);

        UserDetails userDetails = User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities(permissionsArray).build();
        //UserDetails userDetails = User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities("p1").build();
        return userDetails;
        //===================================
        //        //暂时采用模拟方式
        //        //登录账号
        //        System.out.println("username="+username);
        //        //暂时采用模拟方式
        //        UserDetails userDetails = User.withUsername("zhangsan").password("123").authorities("p1").build();
        //        return userDetails;
        //=======================================
    }
}
