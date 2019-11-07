package com.recruit.service.impl;

import com.recruit.entity.Comment;
import com.recruit.entity.Pages;
import com.recruit.entity.Positions;
import com.recruit.entity.User;
import com.recruit.mapper.IAdminMapper;
import com.recruit.mapper.IUserMapper;
import com.recruit.service.IUserService;
import com.recruit.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:容合
 * @create:2019-10-09 10:
 * @description:
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserMapper mapper;

    @Override
    public Page<Positions> getPositionsPage(int currentPage) {
        Page<Positions> positionsPage = new Page<>();
        //1.设置当前页
        positionsPage.setCurrentPage(currentPage);
        //2.设置总条数
        positionsPage.setTotalCount(mapper.getPositionsTotalCount());
        //3.设置每页的显示数据
        positionsPage.setPageSize(5);
        //4.设置每页的数据
        positionsPage.setList(mapper.getPositionsList((currentPage - 1) * positionsPage.getPageSize(), positionsPage.getPageSize()));
        return positionsPage;
    }

    @Override
    public Page<Comment> getCommentPage(Integer pid, Integer currentPage) {
        Page<Comment> commentPage = new Page<>();
        //1.设置当前页
        commentPage.setCurrentPage(currentPage);
        //2.设置总条数
        commentPage.setTotalCount(mapper.getCommentTotalCount(pid));
        //3.设置每页的显示数据
        commentPage.setPageSize(3);
        //4.设置每页的数据
        commentPage.setList(mapper.getCommentList(pid, (currentPage - 1) * commentPage.getPageSize(), commentPage.getPageSize()));
        return commentPage;
    }

    @Override
    public Integer addComment(Comment comment) {
        return mapper.addComment(comment);
    }

    @Override
    public Page<Positions> searchPostPage(String name, Integer currentPage) {
        Page<Positions> positionsPage = new Page<>();
        //1.设置当前页
        positionsPage.setCurrentPage(currentPage);
        //2.设置总条数
        positionsPage.setTotalCount(mapper.searchPostTotalCount(name));
        //3.设置每页的显示数据
        positionsPage.setPageSize(5);
        //4.设置每页的数据
        positionsPage.setList(mapper.searchPost(name, (currentPage - 1) * positionsPage.getPageSize(), positionsPage.getPageSize()));
        return positionsPage;
    }

    /* --------------------------------------------------*/
    //用户登录
    @Override
    public User userLogin(User user) {
        //判断用户是否存在,存在则返回对象,不存在返回null
        User user1 = mapper.userLogin(user);
        if (user1 != null) {
            return user1;
        }
        return null;

    }


    //用户注册
    @Override
    public Integer addUser(User user) {
        Integer rSet = mapper.addUser(user);
        //判断是否添加成功,返回用户主键id,大于0为注册成功,否则不成功,返回0
        if (rSet > 0) {
            return rSet;
        }
        return 0;

    }


    //用户信息查询
    @Override
    public User findUser(Integer id) {
        User user = mapper.findById(id);
        return user;
    }


    //用户信息修改
    @Override
    public Integer updateUser(User user) {
        Integer rSet = mapper.updateUser(user);

        if (rSet > 0) {
            return rSet;
        }
        return 0;

    }


    //提交简历
    @Override
    public Integer submitUser(User user) {
        Integer rSet = mapper.submitUser(user);

        if (rSet > 0) {
            return rSet;
        }
        return 0;


    }


    //撤销简历
    @Override
    public Integer recallUser(User user) {
        Integer rSet = mapper.recallUser(user);

        if (rSet > 0) {
            return rSet;
        }
        return 0;


    }

    /*-----------李绮珊------------*/
    //获取简历总条数
    @Override
    public Integer getTotalCount() {
        Integer totalCount = mapper.getTotalCount();
        return totalCount;

    }

    //分页展示所有的简历信息
    @Override
    public List<User> getPageUser(Pages pages) {
        List<User> pageUser = mapper.getPageUser(pages);
        return pageUser;
    }

    @Override
    public Pages getPage(Integer current) {
        Pages pages =new Pages();
        pages.setCurrentPage(current);
        pages.setTotalCount(mapper.getTotalCount());
        pages.setPageSize(5);
        pages.setOffset((current-1)* pages.getPageSize());
        return pages;


    }
}
