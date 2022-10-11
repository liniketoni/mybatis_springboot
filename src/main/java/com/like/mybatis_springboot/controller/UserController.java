package com.like.mybatis_springboot.controller;

import com.like.mybatis_springboot.common.Result;
import com.like.mybatis_springboot.pojo.User;
import com.like.mybatis_springboot.service.UserService;
import com.like.mybatis_springboot.utils.ImageUtil;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    //获取用户文件
    @PostMapping("/UpUser")
    public void upload(@RequestBody User admin,HttpServletRequest request)  throws Base64DecodingException {
        ImageUtil igu=new ImageUtil();
        Date date=new Date(System.currentTimeMillis());
        System.out.println(date);
        //在这里可以直接写入base64的值进行测试
        String path = igu.saveImg(admin.getUser_Avatar());
        //将路径保存到数据库中
        admin.setU_update(date);
        admin.setUser_Avatar(path);
        userService.UpUserInfo(admin);
        request.getSession().setAttribute("User",admin.getUser_id());
    }
    @GetMapping("/Home")
    public Result<List<User>> index(){
        return Result.success(userService.listUser());
    }

    @PostMapping("/login")
    public Result<User> login(HttpServletRequest request,@RequestBody User user){
        String password=user.getPassword();
        //5dm处理
        password=DigestUtils.md5DigestAsHex(password.getBytes());
        //根据用户输入的id查询
        User admin = userService.UserSelect(user.getUser_id());
        //取得头像地址并转为besa64
        ImageUtil igu=new ImageUtil();
        String src=admin.getUser_Avatar();
        //如果数据库存储地址为空会报错
        if(!src.equals("")){
        admin.setUser_Avatar(igu.GetImageStr(src));;
        }

        //判断用户是否存在{
        //            return Result.error("用户不存在");
        //        }
        if(admin ==null)
        //密码比对
        if(!admin.getPassword().equals(password)){
            return Result.error("密码错误");
        }
        //登录成功将用户id存入Session并返回结果
        request.getSession().setAttribute("User",admin.getUser_id());
        return Result.success(admin);
    }

//
//    @PostMapping("/list")
//    public List<User> index_01(){
//        return userService.listUser();
//    }
}
