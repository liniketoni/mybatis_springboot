package com.like.mybatis_springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

@Data

public class User implements Serializable {
    private String user_id;
    private String User_no;
    private String user_Avatar;
    private String user_name;
    private boolean Admin;
    private String admin_root;
    private String password;
    private String user_phone;
    private int user_state;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date u_update;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date u_createdate;
}
