package com.recruit.service.impl;

import com.recruit.entity.Pages;
import com.recruit.entity.Positions;
import com.recruit.mapper.IPositionsMapper;
import com.recruit.service.IPositionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/iPositionsService")
public class PositionsServiceImpl implements IPositionsService {

    @Resource
    private IPositionsMapper positionsMapper;

    //分页展示所有的职位信息
    @Override
    public List<Positions> getCur(Pages pages) {
        List<Positions> cur = positionsMapper.getCur(pages);
        return cur;
    }



    //通过id获取岗位对象
    @Override
    public Positions getPosById(Integer id) {
        Positions pos = positionsMapper.getPosById(id);
        return pos;
    }

    //获取详情
    @Override
    public Positions getDetail(Positions position) {
        Positions detail = positionsMapper.getDetail(position);
        return detail;
    }

    //获取总条数
    @Override
    public Integer getTotalCount() {
        Integer totalCount = positionsMapper.getTotalCount();
        return totalCount;
    }

    @Override
    public Pages getPage(Integer currentPage) {
        Pages pages =new Pages();
        pages.setCurrentPage(currentPage);
        pages.setTotalCount(positionsMapper.getTotalCount());
        pages.setPageSize(5);
        pages.setOffset((currentPage-1)* pages.getPageSize());
        return pages;
    }

}
