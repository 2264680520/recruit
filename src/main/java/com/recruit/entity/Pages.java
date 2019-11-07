package com.recruit.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Pages<T> {
    //当前页
    private Integer currentPage;
    //每页数据量
    private Integer pageSize;
    //总页数
    private Integer pageCount;
    //数据总条数
    private Integer totalCount;
    private Integer offset;

    private List<T> list;


    public Pages() {
    }




}
