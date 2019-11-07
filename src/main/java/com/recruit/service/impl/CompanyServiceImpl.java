package com.recruit.service.impl;

import com.recruit.entity.Company;
import com.recruit.entity.Employ;
import com.recruit.entity.Positions;
import com.recruit.entity.User;
import com.recruit.mapper.ICompanyMapper;
import com.recruit.service.ICompanyService;
import com.recruit.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Resource
    private ICompanyMapper iCompanyMapper;


    @Override
    public Page<Positions> getPositionsPage(Integer id, Integer currentPage) {
        Page<Positions> positionsPage = new Page<>();
        //1.设置当前页
        positionsPage.setCurrentPage(currentPage);
        //2.设置总条数
        positionsPage.setTotalCount(iCompanyMapper.getPositionsTotalCount(id));
        //3.设置每页的显示数据
        positionsPage.setPageSize(5);
        //4.设置每页的数据
        positionsPage.setList(iCompanyMapper.getPositionsList(id, (currentPage - 1) * positionsPage.getPageSize(), positionsPage.getPageSize()));
        return positionsPage;
    }

    @Override
    public Positions getPositionsById(Integer id) {
        return iCompanyMapper.getPositionsById(id);
    }

    @Override
    public Integer updatePositionsByCompany(Positions positions) {
        return iCompanyMapper.updatePositionsByCompany(positions);
    }

    @Override
    public Integer addPositions(Positions positions) {
        return iCompanyMapper.addPositions(positions);
    }

    @Override
    public Page<Employ> getEmployPage(Integer id, Integer currentPage) {
        Page<Employ> employPage = new Page<>();
        //1.设置当前页
        employPage.setCurrentPage(currentPage);
        //2.设置总条数
        employPage.setTotalCount(iCompanyMapper.getEmployTotalCount(id));
        //3.设置每页的显示数据
        employPage.setPageSize(5);
        //4.设置每页的数据
        employPage.setList(iCompanyMapper.getEmployList(id, (currentPage - 1) * employPage.getPageSize(), employPage.getPageSize()));
        return employPage;
    }

    @Override
    public Integer updateEmployByCompany(Integer id, Integer stauts) {
        return iCompanyMapper.updateEmployByCompany(id, stauts);
    }

    @Override
    public Page<Positions> getAllPssPage(Integer id, Integer currentPage) {
        Page<Positions> positionsPage = new Page<>();
        //1.设置当前页
        positionsPage.setCurrentPage(currentPage);
        //2.设置总条数
        positionsPage.setTotalCount(iCompanyMapper.getPssTotalCount(id));
        //3.设置每页的显示数据
        positionsPage.setPageSize(5);
        //4.设置每页的数据
        positionsPage.setList(iCompanyMapper.selectAllPss(id, (currentPage - 1) * positionsPage.getPageSize(), positionsPage.getPageSize()));
        return positionsPage;
    }

    /*
    王
    ----------------------------------------
    */
//企业登录
    @Override
    public Company companyLogin(Company company) {
        Company com = iCompanyMapper.companyLogin(company);
        //判断企业是否存在,存在则返回对象,不存在返回null
        if (com != null) {
            return com;
        }
        return null;
    }

    //企业注册
    @Override
    public Integer addCompany(Company company) {
        Integer rSet = iCompanyMapper.addCompany(company);
        //判断是否添加成功,返回企业主键id,大于0为注册成功,否则不成功,返回0
        if (rSet > 0) {
            return rSet;
        }
        return 0;
    }

    //企业信息查询
    @Override
    public Company findCompany(Integer id) {
        Company newCompany = iCompanyMapper.findCompany(id);
        return newCompany;
    }

    //企业信息修改
    @Override
    public Integer updateCompany(Company company) {
        Integer rSet = iCompanyMapper.updateCompany(company);
        //判断是否修改成功,返回影响行数,大于0为修改成功,否则不成功,返回0
        if (rSet > 0) {
            return rSet;
        }
        return 0;
    }
}
