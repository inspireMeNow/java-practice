package com.ray.service;

import com.ray.pojo.course;
import com.ray.service.impl.courseServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class courseServiceImplTest {

    @Test
    public void findAllCourse() {
        courseService courseService = new courseServiceImpl();
        List<course> course = courseService.findAllCourse();
        System.out.println(course);
        assert course != null;
    }

    @Test
    public void findCourseById() {
        courseService courseService = new courseServiceImpl();
        course course = courseService.findCourseById("CS0003");
        System.out.println(course.toString());
        assert course != null;
    }

    @Test
    public void updateCourseById() {
        courseService courseService = new courseServiceImpl();
        course course = new course("CS0005","assssdswda",2,2,"10000008");
        int isSuccess = courseService.updateCourseById(course);
        System.out.println(isSuccess);
    }

    @Test
    public void deleteCourseById() {
        courseService courseService = new courseServiceImpl();
        int isSuccess = courseService.deleteCourseById("CS0005");
        System.out.println(isSuccess);
    }

    @Test
    public void insertCourse() {
        courseService courseService = new courseServiceImpl();
        course course = new course("CS0005","asdswda",2,2,"10000008");
        int isSuccess = courseService.insertCourse(course);
        System.out.println(isSuccess);
    }
}