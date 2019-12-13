package com.cxgedu.security.springboot.model;

import lombok.Data;

/**
 * Created by YTF
 * 2019/12/10
 */
@Data
public class PermissionDto {
    private String id;
    private String code;
    private String description;
    private String url;
}
