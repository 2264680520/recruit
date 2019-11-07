package com.recruit.mapper;

import com.recruit.entity.*;
import com.recruit.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Mapper
 */
public interface IAdminMapper {
    /**
     * 获取所有记录总数
     *
     * @return
     */
    int getUserTotalCount();

    /**
     * 分页显示
     *
     * @return
     */
    List<User> getUserList(int offset, int pageSize);

    /**
     * 根据id找到用户实体类
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
     * 获取所有企业用户记录总数
     *
     * @return
     */
    int getCompanyTotalCount();

    /**
     * 分页显示企业用户
     *
     * @return
     */
    List<Company> getCompanyList(int offset, int pageSize);

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
     * 获取所有职位记录总数
     *
     * @return
     */
    int getPositionsTotalCount();

    /**
     * 分页显示职位
     *
     * @return
     */
    List<Positions> getPositionsList(int offset, int pageSize);

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
     * 获取所有评论总数
     *
     * @return
     */
    Integer getPositionsWithCompany();

    /**
     * 查询评论关联职位表以及公司
     *
     * @return
     */
    List<Comment> findPositionsWithCompany(int offset, int pageSize);

    /**
     * 计算评论总数
     * @return
     */
    Integer getCommentTotalCount(Integer id);
    /**
     * 根据职位id找到评论内容
     *
     * @param id
     * @return
     */
    List<Comment> getCommentByPositionsId(@Param("id")int id,@Param("arg0") int offset,@Param("arg1") int pageSize);
}
