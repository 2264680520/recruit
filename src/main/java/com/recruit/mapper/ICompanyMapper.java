package com.recruit.mapper;

import com.recruit.entity.Company;
import com.recruit.entity.Employ;
import com.recruit.entity.Positions;
import com.recruit.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业mapper
 */
public interface ICompanyMapper {

    /**
     * 获取所有职位记录总数
     *
     * @return
     */
    int getPositionsTotalCount(Integer cId);

    /**
     * 获取所有的根据id获取本公司所有的招聘职位
     *
     * @return
     */
    List<Positions> getPositionsList(@Param("id") Integer cId, @Param("arg0") int offset, @Param("arg1") int pageSize);

    /**
     * 通过职位id获取职位信息
     *
     * @param id
     * @return
     */
    Positions getPositionsById(Integer id);

    /**
     * 公司修改招聘信息
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
     * 获取所有的申请记录总数
     *
     * @param id
     * @return
     */
    int getEmployTotalCount(Integer id);

    /**
     * 根据公司id获取所有的申请本公司的用户
     *
     * @param cId
     * @param offset
     * @param pageSize
     * @return
     */
    List<Employ> getEmployList(@Param("id") Integer cId, @Param("arg0") int offset, @Param("arg1") int pageSize);

    /**
     * 给求职者进行审核，同意，拒绝等
     *
     * @param id
     * @param stauts
     * @return
     */
    Integer updateEmployByCompany(@Param("id") Integer id, @Param("stauts") Integer stauts);

    /**
     * @param cId
     * @param offset
     * @param pageSize
     * @return
     */
    List<Positions> selectAllPss(@Param("c_id") Integer cId, @Param("arg0") int offset, @Param("arg1") int pageSize);

    /**
     * 计算职位通过记录数
     *
     * @param id
     * @return
     */
    Integer getPssTotalCount(Integer id);


   /*  王庆球___________________________________________*/

    //企业登录
    Company companyLogin(@Param("companyLogin") Company company);

    //企业注册
    Integer addCompany(@Param("addCompany") Company company);

    //企业信息查询
    Company findCompany(@Param("findCompany") Integer id);

    //企业信息修改
    Integer updateCompany(@Param("updateCompany") Company company);

    /*----------------李绮珊-------------*/
    List<Company> findCompanyByCid(@Param("cid")Integer cid);
}
