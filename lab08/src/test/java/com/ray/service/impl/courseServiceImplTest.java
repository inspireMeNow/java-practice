package com.ray.service.impl;

import com.ray.Lab05Application;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class courseServiceImplTest {
@Resource
courseServiceImpl courseService;
    @Test
    void findAllCourse() {
        System.out.println(courseService.findAllCourse());
    }
    @Test
    void findCourseById(){
        System.out.println(courseService.findCourseById("CS0002"));
    }
    @Test
    void findCourseByTech(){
        System.out.println(courseService.findCourseByTech("10000008"));
    }
}