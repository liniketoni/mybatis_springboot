package com.like.mybatis_springboot;

import com.like.mybatis_springboot.pojo.query.UserQuery;
import com.like.mybatis_springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisSpringbootApplicationTests {

    @Autowired
    private UserService userService;



    @Test
    void contextLoads() {
    System.out.println(userService.listUser());
//    System.out.println(userService.listUserByA_user_id(new UserQuery()));
    System.out.println(userService.UserSelect("985355343"));
    }

}
