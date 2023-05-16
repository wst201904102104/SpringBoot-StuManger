package com.itwst.resolver;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.exceptions.TemplateInputException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
public class MyException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView model = new ModelAndView();
        if (ex instanceof EmptyResultDataAccessException){
            model.setViewName("index");
        }
        return model;
    }
}
