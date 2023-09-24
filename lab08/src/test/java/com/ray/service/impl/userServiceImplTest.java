package com.ray.service.impl;

import com.ray.pojo.user;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class userServiceImplTest {
@Resource
userServiceImpl userService;
    @Test
    void findAllUser() {

    }

    @Test
    void findUserById() {
    }

    @Test
    void login() {
        System.out.println(userService.login(new user("10000000","","123456",2)));
    }

    @Test
    void updateUserById() {
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void insertUser() {
        System.out.println(userService.insertUser(new user("10000000","admin@163.com","123456",2)));
    }
}