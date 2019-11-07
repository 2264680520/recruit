package com.recruit.service;

import com.recruit.entity.Comment;
import com.recruit.entity.Pages;
import com.recruit.entity.Positions;
import com.recruit.entity.User;
import com.recruit.utils.Page;

import java.util.List;

public interface IUserService {
    /**
     * 获取职位分页的内容
     *
     * @return
     */
    Page<Positions> getPositionsPage(int currentPage);

    /**
     * 分页查询所有的评论语句
     *
     * @param pid
     * @param currentPage
     * @return
     */
    Page<Comment> getCommentPage(Integer pid, Integer currentPage);

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    Integer addComment(Comment comment);

    /**
     * 分页查询所有模糊查询的职位
     *
     * @param name
     * @param currentPage
     * @return
     */
    Page<Positions> searchPostPage(String name, Integer currentPage);

    /* ---------------------------------------------*/

    //用户登录
    User userLogin(User user);


    //用户注册
    Integer addUser(User user);


    User findUser(Integer id);

    Integer updateUser(User user);

    Integer submitUser(User user);


    Integer recallUser(User user);
    /*----------李绮珊---------*/

    //获取简历总条数
    Integer getTotalCount();

    List<User> getPageUser(Pages pages);

    Pages getPage(Integer current);
}
