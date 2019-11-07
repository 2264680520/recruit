package com.recruit.utils;

import java.util.List;

/**
 * @author:容合
 * @create:2019-09-04 19:
 * @description:
 */
public class Page<T> {
    private int currentPage;//当前页
    private int pageCount;//总页数
    private int pageSize;//每页展示的数据行
    private int totalCount;//总条数
    private List<T> list;//每页包含的数据

    public Page() {
    }

    public Page(int currentPage, int pageCount, int pageSize, int totalCount, List<T> list) {
        this.currentPage = currentPage;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if (totalCount > 0 && pageSize > 0) {
            pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        if (totalCount > 0 && pageSize > 0) {
            pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        }
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }
}

