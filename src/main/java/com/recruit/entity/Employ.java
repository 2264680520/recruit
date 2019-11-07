package com.recruit.entity;

import lombok.Data;

/**
 * @author:容合
 * @create:2019-10-08 09:
 * @description:
 */
@Data
public class Employ {
    private Integer id;
    private Integer u_id;
    private Integer p_id;
    private Integer stauts;
    private Positions positions;
    private String days;
    private User user;


    public Employ() {
    }

    public Employ(Integer u_id, Integer p_id, String days) {
        this.u_id = u_id;
        this.p_id = p_id;
        this.days = days;
    }

    public Employ(Integer u_id, Integer p_id, Integer stauts, String days) {
        this.u_id = u_id;
        this.p_id = p_id;
        this.stauts = stauts;
        this.days = days;
    }
}
