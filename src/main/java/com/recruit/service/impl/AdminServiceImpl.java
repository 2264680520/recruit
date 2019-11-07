package com.recruit.service.impl;

import com.recruit.entity.*;
import com.recruit.mapper.IAdminMapper;
import com.recruit.service.IAdminService;
import com.recruit.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:容合
 * @create:2019-10-02 17:
 * @description:
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    private IAdminMapper mapper;

    @Override
    public Page<User> getUserPage(int currentPage) {
        Page<User> userPage = new Page<>();
        //1.设置当前页
        userPage.setCurrentPage(currentPage);
        //2.设置总条数
        userPage.setTotalCount(mapper.getUserTotalCount());
        //3.设置每页的显示数据
        userPage.setPageSize(10);
        //4.设置每页的数据
        userPage.setList(mapper.getUserList((currentPage - 1) * userPage.getPageSize(), userPage.getPageSize()));
        return userPage;
    }

    @Override
    public User getUserById(Integer id) {
        return mapper.getUserById(id);
    }

    @Override
    public Integer updateUserByAdmin(User user) {
        return mapper.updateUserByAdmin(user);
    }

    @Override
    public Page<Company> getCompanyPage(int currentPage) {
        Page<Company> companyPage = new Page<>();
        //1.设置当前页
        companyPage.setCurrentPage(currentPage);
        //2.设置总条数
        companyPage.setTotalCount(mapper.getCompanyTotalCount());
        //3.设置每页的显示数据
        companyPage.setPageSize(10);
        //4.设置每页的数据
        companyPage.setList(mapper.getCompanyList((currentPage - 1) * companyPage.getPageSize(), companyPage.getPageSize()));
        return companyPage;
    }

    @Override
    public Company getCompanyById(Integer id) {
        return mapper.getCompanyById(id);
    }

    @Override
    public Integer updateCompanyByAdmin(Company company) {
        return mapper.updateCompanyByAdmin(company);
    }

    @Override
    public Page<Positions> getPositionsPage(int currentPage) {
        Page<Positions> positionsPage = new Page<>();
        //1.设置当前页
        positionsPage.setCurrentPage(currentPage);
        //2.设置总条数
        positionsPage.setTotalCount(mapper.getPositionsTotalCount());
        //3.设置每页的显示数据
        positionsPage.setPageSize(10);
        //4.设置每页的数据
        positionsPage.setList(mapper.getPositionsList((currentPage - 1) * positionsPage.getPageSize(), positionsPage.getPageSize()));
        return positionsPage;
    }

    @Override
    public Positions getPositionsById(Integer id) {
        return mapper.getPositionsById(id);
    }

    @Override
    public Integer positionsPss(Integer id) {
        return mapper.positionsPss(id);
    }

    @Override
    public Page<Comment> getPositionsWithCompanyPage(int currentPage) {
        Page<Comment> commentPage = new Page<>();
        //1.设置当前页
        commentPage.setCurrentPage(currentPage);
        //2.设置总条数
        commentPage.setTotalCount(mapper.getPositionsWithCompany());
        //3.设置每页的显示数据
        commentPage.setPageSize(5);
        //4.设置每页的数据
        commentPage.setList(mapper.findPositionsWithCompany((currentPage - 1) * commentPage.getPageSize(), commentPage.getPageSize()));
        return commentPage;
    }



    @Override
    public Page<Comment> getCommentPage(Integer id, Integer currentPage) {
        Page<Comment> commentPage = new Page<>();
        //1.设置当前页
        commentPage.setCurrentPage(currentPage);
        //2.设置总条数
        commentPage.setTotalCount(mapper.getCommentTotalCount(id));
        //3.设置每页的显示数据
        commentPage.setPageSize(5);
        //4.设置每页的数据
        commentPage.setList(mapper.getCommentByPositionsId(id,(currentPage - 1) * commentPage.getPageSize(), commentPage.getPageSize()));
        return commentPage;
    }


}
