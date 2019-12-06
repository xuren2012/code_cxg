package com.cxgedu.security.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.Set;

/**
 * Created by YTF
 * 2019/12/5
 */
@Data
@AllArgsConstructor
public class UserDto {
   public static final String SESSION_USER_KEY = "_user";
    //用户身份信息
   private String id;
   private String username;
   private String password;
   private String fullname;
   private String mobile;

   /**
    * 用户权限
    */
   private Set<String> authorities;
}
