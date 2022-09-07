package com.like.mybatis_springboot.pojo.query;

import lombok.Data;

@Data
public class UserQuery {
    private Integer pageNum=2;
    private Integer pageSIze=2;
    private String name;
}
