package com.cxgedu.security.springboot.model.dao;

import com.cxgedu.security.springboot.model.PermissionDto;
import com.cxgedu.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by YTF
 * 2019/12/10
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //根据账号查询用户信息
    public UserDto getUserByUsername(String username){
        String sql = "select id,username,password,fullname,mobile from t_user where username=?";
        List<UserDto> list = jdbcTemplate.query(sql, new Object[]{username}, new BeanPropertyRowMapper<>(UserDto.class));
        if(list == null && list.size()<=0){
            return null;
        }
        return list.get(0);

    }

    //根据用户id查询用户权限
    public List<String> findPermissionByUserId(String userId){
      String sql = "SELECT * FROM t_permission WHERE id IN(\n" +
                     " SELECT permission_id FROM t_role_permission WHERE role_id IN(\n" +
                      "   SELECT role_id FROM t_user_role WHERE user_id=?\n" +
                     "   )\n" +
                     "  )";
        List<PermissionDto> list = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(PermissionDto.class));
        List<String> permissions = new ArrayList<>();
        list.forEach(c->permissions.add(c.getCode()));
        return permissions;
    }
}
