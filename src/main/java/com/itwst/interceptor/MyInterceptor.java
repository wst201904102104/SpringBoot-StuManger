package com.itwst.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null){
            response.getWriter().print("<script language='javaScript'>alert('The user is logged in');</script>");
            response.setHeader("refresh","0;url=index.html");
            return false;
        }else {
            return true;
        }
    }

}
