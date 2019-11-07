package com.recruit.entity;

import lombok.Data;

/**
 * @author:容合
 * @create:2019-10-05 14:
 * @description:
 */
@Data
public class Comment {
    private Integer id;
    private Integer u_id;
    private Integer p_id;
    private String content;
    private String rtime;
    private Integer count;
    private Company company;
    private Positions positions;
    private User user;//评论内容人

}
