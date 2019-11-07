package com.recruit.service.impl;

import com.recruit.entity.Employ;
import com.recruit.entity.Pages;
import com.recruit.mapper.IEmployMapper;
import com.recruit.service.IEmployService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/iemployService")
public class EmployServiceImpl implements IEmployService {
    @Resource
    private IEmployMapper employMapper;

    //申请岗位
    @Override
    public Integer submitPosition(Employ employ) {
        Integer rSet = employMapper.submitPosition(employ);
        return rSet;
    }


    //分页展示已申请职位
    @Override
    public List<Employ> getPageSubmit(Pages pages, Integer u_id) {
        List<Employ> pageSubmit = employMapper.getPageSubmit(pages,u_id);
        return pageSubmit;
    }

    //撤销申请
    @Override
    public Integer deleteSubmit(Integer id) {
        Integer rSet = employMapper.deleteSubmit(id);
        return rSet;
    }

    //获取已审核的申请
    @Override
    public List<Employ> getMassage(Pages pages, Integer u_id) {
        List<Employ> massage = employMapper.getMassage(pages,u_id);
        return massage;
    }

    @Override
    public Pages getPage(Integer currentPage) {
        Pages pages =new Pages();
        pages.setCurrentPage(currentPage);
        pages.setPageSize(5);
        pages.setOffset((currentPage-1)* pages.getPageSize());
        return pages;
    }

    //获取已申请的总条数
    @Override
    public Integer getTotalCount(Integer u_id) {
        Integer totalCount = employMapper.getTotalCount(u_id);
        return totalCount;
    }

    //获取消息的总条数
    @Override
    public Integer getTotal(Integer u_id) {
        Integer total = employMapper.getTotal(u_id);
        return total;
    }

    //发送邀请
    @Override
    public Integer invite(Employ employ) {
        Integer invite = employMapper.invite(employ);
        return invite;
    }
}
