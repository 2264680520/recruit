package com.recruit.mapper;

import com.recruit.entity.Pages;
import com.recruit.entity.Positions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPositionsMapper {

    //通过id获取岗位对象
    Positions getPosById(@Param("id") Integer id);

    //获取详情
    Positions getDetail(@Param("position") Positions position);

    //获取总条数
    Integer getTotalCount();

    //分页展示所有的职位信息
    List<Positions> getCur(@Param("page") Pages pages);

}
