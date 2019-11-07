package com.recruit.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author:容合
 * @create:2019-10-02 16:
 * @description:
 */
@Data
public class User {
    private Integer id;//用户id
    private String username;//用户账号
    private String password;//用户密码
    private String name;//用户真实姓名
    private String sex;//性别
    private String birthday;//出生日期
    private String school;//毕业学校
    private String phone;//电话
    private String email;//邮箱
    private String trade;//专业
    private String salary;//期望薪资
    private String tip;//个人经历
    private Integer stauts;//状态是否发布了简历

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
