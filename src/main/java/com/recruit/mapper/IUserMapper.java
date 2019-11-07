package com.recruit.mapper;

import com.recruit.entity.Comment;
import com.recruit.entity.Pages;
import com.recruit.entity.Positions;
import com.recruit.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:容合
 * @create:2019-10-09 10:
 * @description:
 */
public interface IUserMapper {
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
     * 根据职位id找到对应的评论列表
     *
     * @param pId
     * @param offset
     * @param pageSize
     * @return
     */
    List<Comment> getCommentList(@Param("pid") Integer pId, @Param("arg0") int offset, @Param("arg1") int pageSize);

    /**
     * 查询所有的查询语句总数
     *
     * @param pid
     * @return
     */
    int getCommentTotalCount(int pid);

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    Integer addComment(Comment comment);

    /**
     * 模糊查询总条数
     *
     * @param name
     * @return
     */
    Integer searchPostTotalCount(String name);

    /**
     * 模糊查询内容
     *
     * @param name
     * @param offset
     * @param pageSize
     * @return
     */
    List<Positions> searchPost(@Param("name") String name, @Param("arg0") int offset, @Param("arg1") int pageSize);

    /*----------------------------------------------*/
    //用户登录
    User userLogin(@Param("user") User user);


    //用户注册
    Integer addUser(@Param("addUser") User user);


    User findById(@Param("id") int id);


    Integer updateUser(@Param("user") User user);
    Integer submitUser(@Param("user") User user);



    Integer recallUser(@Param("user") User user);

    /*-------------李绮珊-------------------*/
    //获取简历总条数
    Integer getTotalCount();
    //分页展示所有的简历信息
    List<User> getPageUser(@Param("pages") Pages pages);
}
