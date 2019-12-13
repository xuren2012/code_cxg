package com.cxgedu.security.springboot.model;

import lombok.Data;

/**
 * Created by YTF
 * 2019/12/10
 */
@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
