package com.recruit.controller;

import com.recruit.entity.Company;
import com.recruit.entity.Employ;
import com.recruit.entity.Pages;
import com.recruit.entity.User;
import com.recruit.service.IEmployService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employ")
public class EmployController {
    @Resource
    private IEmployService employService;

    //申请职位
    @RequestMapping("/submitPosition")
    public Integer submitPosition(String id, HttpSession session) {
        System.out.println("id:" + id);
        Integer p_id = Integer.parseInt(id);
        User company = (User) session.getAttribute("user_session");
        Integer u_id = company.getId();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = df.format(date);
        System.out.println(time);
        Integer rSet = employService.submitPosition(new Employ(u_id, p_id, time));
        System.out.println("rSet:" + rSet);
        return rSet;
    }

    //分页展示所有的已申请职位
    @RequestMapping("/getPageSubmit")
    public Pages getPageSubmit(String current, HttpSession session) {
        System.out.println("当前页" + current);

        User user = (User) session.getAttribute("user_session");
        Integer u_id = user.getId();
        System.out.println("u_id" + u_id);
        Integer cur = Integer.parseInt(current);
        Pages pages = employService.getPage(cur);
        List<Employ> employ = employService.getPageSubmit(pages, u_id);
        System.out.println("employ111" + employ);
        pages.setList(employ);
        Integer totalCount1 = employService.getTotalCount(u_id);
        System.out.println("totalCount:" + totalCount1);
        pages.setTotalCount(totalCount1);
        Integer totalCount = pages.getTotalCount();
        Integer pageSize = pages.getPageSize();
        pages.setPageCount(totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
        System.out.println(pages);
        return pages;


    }


    //撤销申请
    @RequestMapping("/deleteSubmit")
    public Integer deleteSubmit(String sid) {
        Integer id = Integer.parseInt(sid);
        Integer rSet = employService.deleteSubmit(id);
        System.out.println("rSet:" + rSet);
        return rSet;
    }

    @RequestMapping("/massage")
    public Pages getPageMassage(String current, HttpSession session) {
        User company = (User) session.getAttribute("user_session");
        Integer u_id = company.getId();
        Integer cur = Integer.parseInt(current);
        Pages pages = employService.getPage(cur);
        List<Employ> massage = employService.getMassage(pages, u_id);
        pages.setList(massage);
        Integer total = employService.getTotal(u_id);
        pages.setTotalCount(total);
        Integer totalCount = pages.getTotalCount();
        Integer pageSize = pages.getPageSize();
        pages.setPageCount(totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
        System.out.println(pages);
        return pages;
    }

    //邀请面试
    @RequestMapping(value = "/invite", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer invite(String id, HttpSession session) {
        System.out.println("id:" + id);
        //通过session获取公司id
        Company company = (Company) session.getAttribute("company_session");
        Integer c_id = company.getId();
        Integer uid = Integer.parseInt(id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = df.format(date);
        Integer rSet = employService.invite(new Employ(uid, c_id, 3, time));
        System.out.println(rSet);
        return rSet;
    }

}
