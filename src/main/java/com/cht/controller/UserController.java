package com.cht.controller;

import com.cht.pojo.User;

import com.cht.service.UserService;
import lombok.Setter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        System.out.println("去往登录页面");
        return "login";

    }
    @GetMapping("/regist")
    public String registPage(){
        System.out.println("去往注册页面");
        return "regist";
    }
    @PostMapping("/login")
    public String loginLogic(User user,Map<String,Object> map){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("login logic");//登录 逻辑
        //获取subject  调用login
        Subject subject = SecurityUtils.getSubject();
        //创建用于登录的令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 登录失败会抛出异常，则交由异常解析器处理，登录成功，继续往下执行
        try{
            token.setRememberMe(true);
            subject.login(token); //默认从Ini文件获取
        }catch (IncorrectCredentialsException e){
            map.put("message","密码错误");
            return "error";
        }catch (UnknownAccountException e){
            map.put("message","用户名错误");
            return "error";
        }
        return "index";
    }

    @RequestMapping("permission")
    public String permission(){
        return "permission";
    }

    @RequestMapping("all")
    public String all(){
        return "all";
    }

    @PostMapping("regist")
    public String regist(User user){
        userService.insertUser(user);
        return "redirect:/user/login";
    }

    public void a(){
        Subject subject = SecurityUtils.getSubject();
        //获取session
        Session session = subject.getSession();
        //session超时时间，单位，毫秒；0，马上过期；负数，不会过期，正数，对应毫秒后过期
        session.setTimeout(10000);
        //session存取值
        session.setAttribute("name","cht");
        session.getAttribute("name");
        //销毁session
        session.stop();

    }

}