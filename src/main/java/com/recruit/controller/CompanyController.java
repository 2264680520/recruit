package com.recruit.controller;

import com.recruit.entity.Comment;
import com.recruit.entity.Company;
import com.recruit.entity.Employ;
import com.recruit.entity.Positions;
import com.recruit.service.ICompanyService;
import com.recruit.utils.Page;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/company")
@Slf4j
public class CompanyController {

    @Resource
    private ICompanyService iCompanyService;

    /**
     * 公司分页展示所有的职位信息
     *
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/getPositionsPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Positions> getPositionsPage(Integer currentPage, HttpSession session) {
        Company company = (Company) session.getAttribute("company_session");
        Integer id = company.getId();
        System.out.println(currentPage);
        Page<Positions> positionsPage = iCompanyService.getPositionsPage(id, currentPage);
        System.out.println(positionsPage);
        return positionsPage;
    }

    /**
     * 通过职位id获取职位信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getPositionsById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Positions getPositionsById(Integer id) {
        System.out.println(id);
        Positions positions = iCompanyService.getPositionsById(id);
        System.out.println(positions);
        return positions;
    }

    /**
     * 公司修改招聘信息
     *
     * @param positions
     * @return
     */
    @RequestMapping(value = "/updatePositionsByCompany", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer updatePositionsByCompany(Positions positions) {
        if (positions.getStauts() == 1) {
            positions.setStauts(0);
        }
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //设置当前时间
        positions.setPuttime(date);
        Integer integer = iCompanyService.updatePositionsByCompany(positions);
        System.out.println(positions);
        return integer;
    }

    /**
     * 添加招聘
     *
     * @param positions
     * @return
     */
    @RequestMapping(value = "/addPositions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer addPositions(Positions positions, HttpSession session) {
        Company company = (Company) session.getAttribute("company_session");
        Integer id = company.getId();
        //设置职位所属企业
        positions.setC_id(id);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //设置当前时间
        positions.setPuttime(date);
        Integer integer = iCompanyService.addPositions(positions);
        System.out.println(integer);
        return integer;
    }

    /**
     * 分页显示所有的求职者申请记录
     *
     * @param
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/getEmployPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Employ> getEmployPage(Integer currentPage, HttpSession session) {
        Company company = (Company) session.getAttribute("company_session");
        Integer id = company.getId();
        Page<Employ> employPage = iCompanyService.getEmployPage(id, currentPage);
        System.out.println(employPage);
        return employPage;
    }

    /**
     * 给求职者进行审核，同意，拒绝等
     *
     * @param id
     * @param stauts
     * @return
     */
    @RequestMapping(value = "/updateEmployByCompany", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer updateEmployByCompany(Integer id, Integer stauts) {
        Integer integer = null;
        //进行逻辑判断如果是1则是同意，2则是拒绝
        System.out.println(id);
        System.out.println(stauts);
        if (stauts == 1) {
            integer = iCompanyService.updateEmployByCompany(id, stauts);
        } else {
            integer = iCompanyService.updateEmployByCompany(id, stauts);
        }
        return integer;
    }

    /**
     * 聘信息审核通过通知
     *
     * @param currentPage
     * @return
     */
    @RequestMapping(value = "/selectAllPss", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Positions> selectAllPss(Integer currentPage, HttpSession session) {
        Company company = (Company) session.getAttribute("company_session");
        Integer id = company.getId();
        Page<Positions> positionsPage = iCompanyService.getAllPssPage(id, currentPage);
        System.out.println(positionsPage);
        return positionsPage;
    }

    /*王庆球---------------------------------------*/

    //企业注册
    @RequestMapping(value = "/addCompany", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer addCompany(Company company) {
        return iCompanyService.addCompany(company);
    }

    //查询企业信息
    @RequestMapping(value = "/findCompany", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Company findCompany(HttpSession session) {
        //获取登录成功时存在session中的company对象
        Company company = (Company) session.getAttribute("company_session");
        return company;
    }

    //修改企业信息
    @RequestMapping(value = "/updateCompany", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer updateCompany(Company company, HttpSession session) {
        System.out.println(company);
        //调用修改业务逻辑层
        Integer rSet = iCompanyService.updateCompany(company);
        //修改后重新获取修改的对象到session中
        Company newCompany = iCompanyService.findCompany(company.getId());
        session.setAttribute("company_session", newCompany);
        return rSet;
    }

    //注销
    @RequestMapping(value = "/exitCompany", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer exitCompany(HttpSession session, HttpServletResponse response, HttpServletRequest request) {

        session.removeAttribute("company_session");
        return 0;
    }
}
