package com.recruit.entity;

import lombok.Data;

/**
 * @author:容合
 * @create:2019-10-04 16:
 * @description:
 */
@Data
public class Positions {
    private Integer id;
    private String post;
    private String require;
    private String salary;
    private String puttime;
    private Integer c_id;
    private Integer is_delete;
    private Integer stauts;
    private Company company;
}
