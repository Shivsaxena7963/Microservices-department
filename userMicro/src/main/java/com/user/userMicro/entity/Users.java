package com.user.userMicro.entity;

import java.util.Date;

public class Users {


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int userId;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    private String about;
    private String gender;
    private String phone;
    @Column(name="CreateAt")
    private Date date;
    private boolean  active;


}
