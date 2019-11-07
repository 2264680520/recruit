package com.recruit.service;

import com.recruit.entity.Employ;
import com.recruit.entity.Pages;

import java.util.List;

public interface IEmployService {
    //申请岗位
    Integer submitPosition(Employ employ);

    //分页展示已申请职位
    List<Employ> getPageSubmit(Pages pages, Integer u_id);

    //撤销申请
    Integer deleteSubmit(Integer id);
    //获取已审核的申请
    List<Employ> getMassage(Pages pages, Integer u_id);



    //获取已申请的总条数
    Integer getTotalCount(Integer u_id);

    //获取消息的总条数
    Integer getTotal(Integer u_id);

    //发送邀请
    Integer invite(Employ employ);

    Pages getPage(Integer currentPage);
}
