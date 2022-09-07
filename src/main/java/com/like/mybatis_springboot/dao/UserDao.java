package com.like.mybatis_springboot.dao;

import com.like.mybatis_springboot.common.Result;
import com.like.mybatis_springboot.pojo.User;
import com.like.mybatis_springboot.pojo.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Mapper
@Repository
public interface UserDao {
    //账号查询
    public List<User> listUser();

    //分页查询
    public List<User> listUserByName(UserQuery userQuery);

    //查询用户
    public User UserSelect(@Param("user_id") String user_id);
}
