package com.recruit.mapper;

import com.recruit.entity.Employ;
import com.recruit.entity.Pages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployMapper {
    //申请岗位
    Integer submitPosition(@Param("employ") Employ employ);
    //撤销申请
    Integer deleteSubmit(@Param("id") Integer id);

    //分页展示已申请职位
    List<Employ> getPageSubmit(@Param("page") Pages pages, @Param("u_id") Integer u_id);

    //获取所有职业总条数
    Integer getTotalCount(@Param("u_id") Integer u_id);

    //获取消息总条数
    Integer getTotal(@Param("uid") Integer u_id);

    //获取已审核的申请
    List<Employ> getMassage(@Param("page") Pages pages, @Param("u_id") Integer u_id);


    //发送邀请
    Integer invite(@Param("employ") Employ employ);
}
