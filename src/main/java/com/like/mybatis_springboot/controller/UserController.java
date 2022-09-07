package com.like.mybatis_springboot.controller;

import com.like.mybatis_springboot.common.Result;
import com.like.mybatis_springboot.pojo.User;
import com.like.mybatis_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/Home")
    public Result<List<User>> index(){
        return Result.success(userService.listUser());
    }

    @PostMapping("/login")
    public Result<User> login(HttpServletRequest request,@RequestBody User user){
        String password=user.getPassword();
        System.out.println("lk："+password);
        //5dm处理
        password=DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(password);
        //根据用户输入的id查询
        User admin = userService.UserSelect(user.getUser_id());
        System.out.println(admin.getUser_id());
        //判断用户是否存在
        if(admin ==null){
            return Result.error("用户不存在");
        }
        //密码比对
        if(!admin.getPassword().equals(password)){
            return Result.error("密码错误");
        }
        //登录成功将用户id存入Session比返回结果
        request.getSession().setAttribute("User",admin.getUser_id());
        System.out.println(request.getSession().getAttribute("User"));
        return Result.success(admin);
    }

//
//    @PostMapping("/list")
//    public List<User> index_01(){
//        return userService.listUser();
//    }
}
