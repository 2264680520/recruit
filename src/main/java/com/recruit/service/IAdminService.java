package com.recruit.service;

import com.recruit.entity.*;
import com.recruit.utils.Page;

import java.util.List;

/**
 * @author:容合
 * @create:2019-10-02 17:
 * @description:
 */
public interface IAdminService {
    /**
     * 获取用户分页的内容
     *
     * @return
     */
    Page<User> getUserPage(int currentPage);

    /**
     * 根据id找到实体类
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 管理员修改用户信息
     *
     * @param user
     * @return
     */
    Integer updateUserByAdmin(User user);

    /**
     * 获取用户分页的内容
     *
     * @return
     */
    Page<Company> getCompanyPage(int currentPage);

    /**
     * 根据id找到企业实体类对象
     *
     * @param id
     * @return
     */
    Company getCompanyById(Integer id);

    /**
     * 管理员修改企业用户信息
     *
     * @param company
     * @return
     */
    Integer updateCompanyByAdmin(Company company);

    /**
     * 获取职位分页的内容
     *
     * @return
     */
    Page<Positions> getPositionsPage(int currentPage);

    /**
     * 根据id找到职位实体类对象
     *
     * @param id
     * @return
     */
    Positions getPositionsById(Integer id);

    /**
     * 职位审核通过
     *
     * @param id
     * @return
     */
    Integer positionsPss(Integer id);

    /**
     * 获取职位评论的内容
     *
     * @return
     */
    Page<Comment> getPositionsWithCompanyPage(int currentPage);

    /**
     * 分页显示当前的评论内容
     * @param id
     * @param currentPage
     * @return
     */
    Page<Comment> getCommentPage(Integer id, Integer currentPage);
}
