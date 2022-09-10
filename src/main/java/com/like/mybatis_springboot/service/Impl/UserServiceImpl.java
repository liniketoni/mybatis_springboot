package com.like.mybatis_springboot.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.like.mybatis_springboot.dao.UserDao;
import com.like.mybatis_springboot.pojo.User;
import com.like.mybatis_springboot.pojo.query.UserQuery;
import com.like.mybatis_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public PageInfo<User> listUserByName(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSIze());
        return new PageInfo<User>(userDao.listUserByName(userQuery));
    }

    @Override
    public User UserSelect(String user_id) {
        return userDao.UserSelect(user_id);
    }

    @Override
    public void  UpUserInfo(User user) {
         userDao.UpUserInfo(user);
    }
}
