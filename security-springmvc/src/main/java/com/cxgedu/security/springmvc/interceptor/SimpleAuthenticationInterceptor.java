package com.cxgedu.security.springmvc.interceptor;

import com.cxgedu.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by YTF
 * 2019/12/6
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    //请求拦截方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //校验用户了请求的url是否在用户的权限范围内
        //获取用户信息
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if(object == null){
            //没有认证，提示登录
            writeContent(response,"请登录！");
        }
        UserDto userDto = (UserDto)object;
        //请求的url
        String requestURI = request.getRequestURI();
        if(userDto.getAuthorities().contains("p1")&&requestURI.contains("/r/r1")){
           return true;//放行
        }
        if(userDto.getAuthorities().contains("p2")&&requestURI.contains("/r/r2")){
            return true;//放行
        }
        writeContent(response,"没有权限，拒绝访问！");
        return false;
    }
    //响应输出给客户端
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
        response.resetBuffer();//清理缓存
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
