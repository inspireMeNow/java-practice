package com.ray.service.impl;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class studentServiceImplTest {
@Resource
studentServiceImpl studentService;
    @Test
    void findAllStu() {
        System.out.println(studentService.findAllStu());
    }
    @Test
    void findCourseByStu(){
        System.out.println(studentService.findCourseByStu("20204102"));
    }
    @Test
    void deleteStuById(){
        System.out.println(studentService.deleteStuById("20204105"));
    }
}