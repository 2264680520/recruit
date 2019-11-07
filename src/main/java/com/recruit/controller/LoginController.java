package com.recruit.controller;

import com.recruit.entity.Company;
import com.recruit.entity.User;
import com.recruit.service.ICompanyService;
import com.recruit.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/*
 *      登录控制器
 **/
@RestController
@RequestMapping("/loginController")
@Slf4j
public class LoginController {

    @Resource
    private ICompanyService iCompanyService;

    @Resource
    private IUserService iUserService;

    @RequestMapping(value = "/login", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer Login(String username, String password, String category,HttpSession session, HttpServletResponse response) throws UnsupportedEncodingException {
        //判断登录的类别
        if ("user".equals(category)) {
            //创建用户对象
            User user = new User(username, password);
            user = iUserService.userLogin(user);
            if (user != null) {
                session.setAttribute("user_session", user);
                return 1;
            }
            return 0;
        } else if ("company".equals(category)) {
            //创建企业对象
            Company company = new Company(username, password);
            //调用业务逻辑层
            company = iCompanyService.companyLogin(company);
            if (company != null) {

                session.setAttribute("company_session", company);
                return 2;
            }
        }
        return 0;
    }

    @RequestMapping(value = "/adminLogin", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer adminLogin(String adminUsername, String adminPassword)  {
        System.out.println(adminUsername);
        System.out.println(adminPassword);
        if ("admin".equals(adminUsername) && "admin".equals(adminPassword)){
            return 1;
        }
        return 0;
    }
}
