package com.cxgedu.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Created by YTF
 * 2019/12/4
 */
@Configuration    //功能类似于加载applicationContext.xml
@ComponentScan(basePackages = "com.cxgedu.security.springmvc",
              excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {
    //在此配置的是除了Controller之外的bean，比如：数据库连接池、事务管理器、业务bean等
}
