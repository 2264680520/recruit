package com.recruit.controller;

import com.recruit.entity.Pages;
import com.recruit.entity.Positions;
import com.recruit.service.IPositionsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionsController {
    @Resource
    private IPositionsService positionsService;

    //获取职业详情
    @RequestMapping("/getDetail")
    public Positions getDetail(String id){
        Integer pid = Integer.parseInt(id);
        Positions pos = positionsService.getPosById(pid);

        Positions detail = positionsService.getDetail(pos);

        System.out.println(detail);
        return detail;
    }

    //分页展示所有的职位信息
    @RequestMapping("/getPagePositions")
    public Pages getPagePositions(String currentPage){
        Integer cur = Integer.parseInt(currentPage);
        Pages pages = positionsService.getPage(cur);
        List<Positions> positions = positionsService.getCur(pages);
        pages.setList(positions);
        Integer totalCount = pages.getTotalCount();
        Integer pageSize = pages.getPageSize();
        pages.setPageCount(totalCount%pageSize==0 ? totalCount/pageSize:totalCount/pageSize+1);
        return pages;
    }

}
