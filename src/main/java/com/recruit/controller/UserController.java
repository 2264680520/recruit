package com.recruit.controller;

import com.recruit.entity.Comment;
import com.recruit.entity.Pages;
import com.recruit.entity.Positions;
import com.recruit.entity.User;
import com.recruit.service.IAdminService;
import com.recruit.service.IUserService;
import com.recruit.utils.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author:容合
 * @create:2019-10-09 09:
 * @description:
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private IUserService service;

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
     * 页展示所有的评论信息
     *
     * @return
     */
    @RequestMapping(value = "/getCommentPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Comment> getCommentPage(Integer id, Integer currentPage) {
        Page<Comment> commentPage = service.getCommentPage(id, currentPage);
        System.out.println(commentPage);
        return commentPage;
    }

    /**
     * 添加评论
     *
     * @return
     */
    @RequestMapping(value = "/addComment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer addComment(Comment comment, HttpSession session) {
        User user = (User) session.getAttribute("user_session");
        Integer id = user.getId();
        //获取用户的Id
        comment.setU_id(id);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //发表时间
        comment.setRtime(date);
        System.out.println(comment);
        Integer integer = service.addComment(comment);
        return integer;
    }

    /**
     * 搜索框模糊查询
     *
     * @param name
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/searchPostPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Positions> searchPostPage(String name, Integer currentPage) {
        System.out.println(name + "," + currentPage);
        Page<Positions> positionsPage = service.searchPostPage(name, currentPage);
        System.out.println(positionsPage);
        return positionsPage;
    }

    /*------------------------------------------*/


    //用户注册
    @RequestMapping(value = "/addUser", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public Integer addUser(User user) {
        System.out.println(user);
        return service.addUser(user);
    }


    //用户信息查询
    @RequestMapping(value = "/findUser", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User findUser(HttpSession session) {
        User user = (User) session.getAttribute("user_session");

        return user;
    }


    //用户信息修改
    @RequestMapping(value = "/updateUser", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer updateUser(User user, HttpSession session) {
        System.out.println("用户" + user);
        Integer rSet = service.updateUser(user);

        User newUser = service.findUser(user.getId());

        session.setAttribute("user_session", newUser);

        return rSet;
    }


    //提交简历
    @RequestMapping(value = "/submitUser", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer submitUser(HttpSession session) {
        System.out.println("提交简历");
        User user = (User) session.getAttribute("user_session");

        return service.submitUser(user);

    }


    //撤销简历
    @RequestMapping(value = "/recallUser", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer recallUser(HttpSession session) {

        System.out.println("撤销简历");
        User user = (User) session.getAttribute("user_session");

        return service.recallUser(user);

    }

    @RequestMapping(value = "/exitUser", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer exitUser(HttpSession session) {
        session.removeAttribute("user_session");
        return 0;
    }

    /*---------------李绮珊---------------------------*/
    //分页展示所有的已发布简历
    @RequestMapping("/getResume")
    public Pages getResume(String current) {
        System.out.println("current:" + current);
        Integer cur = Integer.parseInt(current);
        Pages page = service.getPage(cur);
        List<User> pageUser = service.getPageUser(page);
        page.setList(pageUser);
        Integer totalCount = page.getTotalCount();
        Integer pageSize = page.getPageSize();
        page.setPageCount(totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
        System.out.println(page);
        return page;

    }
}
