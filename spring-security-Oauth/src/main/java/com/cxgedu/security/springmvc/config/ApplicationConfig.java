package com.cxgedu.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Created by YTF
 * 2019/12/6
 */
@Configuration
@ComponentScan(basePackages = "com.cxgedu.security.springmvc",
               excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
               value = Controller.class)})
public class ApplicationConfig {

}
