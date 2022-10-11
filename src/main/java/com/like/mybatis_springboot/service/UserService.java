package com.like.mybatis_springboot.service;

import com.github.pagehelper.PageInfo;
import com.like.mybatis_springboot.pojo.User;
import com.like.mybatis_springboot.pojo.query.UserQuery;

import java.util.List;

public interface UserService {
    public List<User> listUser();

    //分页查询
    public PageInfo<User> listUserByName(UserQuery userQuery);

    //账号查询
    public User UserSelect(String user_id);

    //修改用户信息
    public void  UpUserInfo(User user);

    //用户注册
    public void Useradd(User user);
}
