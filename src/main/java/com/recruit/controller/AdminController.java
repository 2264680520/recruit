package com.recruit.controller;

import com.recruit.entity.Comment;
import com.recruit.entity.Company;
import com.recruit.entity.Positions;
import com.recruit.entity.User;
import com.recruit.service.IAdminService;
import com.recruit.utils.Page;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

/**
 * @author:容合
 * @create:2019-10-02 18:
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private IAdminService service;

    /**
     * 分页展示所有的用户信息
     *
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/getUserPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<User> getUserPage(Integer currentPage) {
        System.out.println(currentPage);
        //获取分页数据
        Page<User> userPage = service.getUserPage(currentPage);
        System.out.println(userPage);
        return userPage;
    }

    /**
     * 根据id找到对应的用户实体类
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getUserById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUserById(Integer id) {
        User user = service.getUserById(id);
        System.out.println("用户" + user);
        return user;
    }

    /**
     * 管理员修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUserByAdmin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer updateUserByAdmin(User user) {
        Integer count = service.updateUserByAdmin(user);
        System.out.println(count);
        return count;
    }

    /**
     * 分页展示所有的企业用户信息
     *
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/getCompanyPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Company> getCompanyPage(Integer currentPage) {
        System.out.println(currentPage);
        //获取分页数据
        Page<Company> companyPage = service.getCompanyPage(currentPage);
        System.out.println(companyPage);
        return companyPage;
    }

    /**
     * 根据id找到对应的企业实体类对象
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getCompanyById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Company getCompanyById(Integer id) {
        Company company = service.getCompanyById(id);
        System.out.println("用户" + company);
        return company;
    }

    /**
     * 管理员修改企业用户信息
     *
     * @param company
     * @return
     */
    @RequestMapping(value = "/updateCompanyByAdmin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer updateCompanyByAdmin(Company company) {
        System.out.println("企业" + company);
        Integer count = service.updateCompanyByAdmin(company);
        System.out.println(count);
        return count;
    }

    /**
     * 分页展示所有的职位信息
     *
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/getPositionsPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Positions> getPositionsPage(Integer currentPage) {
        System.out.println("当前页" + currentPage);
        //获取分页数据
        Page<Positions> positionsPage = service.getPositionsPage(currentPage);
        System.out.println(positionsPage);
        return positionsPage;
    }

    /**
     * 根据id找到对应的职位实体类对象
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getPositionsById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Positions getPositionsById(Integer id) {
        System.out.println(id);
        Positions positions = service.getPositionsById(id);
        System.out.println("用户" + positions);
        return positions;
    }

    /**
     * 职位审核通过
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/positionsPss", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer positionsPss(Integer id) {
        Integer pss = service.positionsPss(id);
        return pss;
    }

    /**
     * 分页展示所有的评论信息
     *
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/getPositionsWithCompanyPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Comment> getPositionsWithCompanyPage(Integer currentPage) {
        Page<Comment> positionsWithCompanyPage = service.getPositionsWithCompanyPage(currentPage);
        System.out.println(positionsWithCompanyPage);
        return positionsWithCompanyPage;
    }


    /**
     * 分页展示所有的评论信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getCommentPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Comment> getCommentPage(Integer id,Integer currentPage) {
        Page<Comment> commentPage = service.getCommentPage(id, currentPage);
        System.out.println(commentPage);
        return commentPage;
    }


}
