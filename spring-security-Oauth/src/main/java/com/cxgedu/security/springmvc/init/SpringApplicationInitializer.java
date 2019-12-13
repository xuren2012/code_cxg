package com.cxgedu.security.springmvc.init;

import com.cxgedu.security.springmvc.config.ApplicationConfig;
import com.cxgedu.security.springmvc.config.WebConfig;
import com.cxgedu.security.springmvc.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by YTF
 * 2019/12/6
 */

public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //spring容器，相当于加载applicationContext.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class, WebSecurityConfig.class};
    }
    //servletContext 相当于加载springmvc.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    //url-mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
