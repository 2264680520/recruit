package com.recruit.service;

import com.recruit.entity.Pages;
import com.recruit.entity.Positions;

import java.util.List;

public interface IPositionsService {

    //分页展示所有的职位信息
    List<Positions> getCur(Pages pages);
    //通过id获取岗位对象
    Positions getPosById(Integer id);
    //获取详情
    Positions getDetail(Positions position);

    //获取总条数
    Integer getTotalCount();

    Pages getPage(Integer currentPage);
}
