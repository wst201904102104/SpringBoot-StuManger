package com.itwst.controller;

import com.itwst.domain.User;
import com.itwst.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login(Model model,String username, String userpwd, HttpServletRequest request){
        System.out.println("login is running");
        User user = userService.selByuser(username,userpwd);
        if (user != null){
            System.out.println("密码正确");
            HttpSession session = request.getSession();
            session.setAttribute("username",user.getUsername());
            return "main";
        }else {
            System.out.println("密码错误");
            model.addAttribute("message","账号或密码错误");
            return "index";
        }
    }

    @RequestMapping("/enroll")
    public String enroll(String username,String userpwd){
        User user = new User(username, userpwd);
        userService.doEnroll(user);
        System.out.println(user.getUsername());
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String check(String username){
        System.out.println(username);
        User user = userService.doCheck(username);
        System.out.println(user);
        if (user != null){
            return "<p style='color:red'>用户名太受欢迎，请重新输入!</p>";
        }else {
            return "<p style='color:green'>用户名可用!</p>";
        }
    }
}
