package com.recruit.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class Company {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String introdu;

    public Company() {
    }

    public Company(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
