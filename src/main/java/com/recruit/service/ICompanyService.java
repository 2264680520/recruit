package com.recruit.service;

import com.recruit.entity.Comment;
import com.recruit.entity.Company;
import com.recruit.entity.Employ;
import com.recruit.entity.Positions;
import com.recruit.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICompanyService {
    /**
     * 根据公司id分页显示所有的职位
     *
     * @param id
     * @param currentPage
     * @return
     */
    Page<Positions> getPositionsPage(Integer id, Integer currentPage);

    /**
     * 通过职位id获取职位信息
     *
     * @param id
     * @return
     */
    Positions getPositionsById(Integer id);

    /**
     * 修改招聘信息
     *
     * @param positions
     * @return
     */
    Integer updatePositionsByCompany(Positions positions);

    /**
     * 发布招聘
     *
     * @param positions
     * @return
     */
    Integer addPositions(Positions positions);

    /**
     * 分页显示当前的申请本公司的所有用户
     *
     * @param id
     * @param currentPage
     * @return
     */
    Page<Employ> getEmployPage(Integer id, Integer currentPage);

    /**
     * 给求职者进行审核，同意，拒绝等
     *
     * @param id
     * @param stauts
     * @return
     */
    Integer updateEmployByCompany(Integer id, Integer stauts);

    /**
     * 招聘信息审核通过通知
     *
     * @param id
     * @return
     */
    Page<Positions> getAllPssPage(Integer id,Integer currentPage);

    /*王---------------------------*/

    //企业登录
    Company companyLogin(Company company);

    //企业注册
    Integer addCompany(Company company);

    //企业信息查询
    Company findCompany(Integer id);

    //企业信息修改
    Integer updateCompany(Company company);

}
