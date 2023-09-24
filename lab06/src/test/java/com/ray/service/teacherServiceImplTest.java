package com.ray.service;

import com.ray.pojo.course;
import com.ray.pojo.teacher;
import org.junit.Test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class teacherServiceImplTest
{
    @Test
    public void findTechById()
    {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        teacherService teacherService = cpx.getBean("teacherService", teacherService.class);
        teacher teacher = teacherService.findTechById("10000001");
        System.out.println(teacher.toString());
        assert teacher != null;
    }
    @Test
    public void findAllTech()
    {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        teacherService teacherService = cpx.getBean("teacherService", teacherService.class);
        List<teacher> teacher = teacherService.findAllTech();
        System.out.println(teacher.toString());
        assert teacher != null;
    }

    @Test
    public void updateTechById() {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        teacherService teacherService = cpx.getBean("teacherService", teacherService.class);
        teacher teacher = new teacher("10000004","scd","信息学院",10000,"男");
        int isSuccess = teacherService.updateTechById(teacher);
        System.out.println(isSuccess);
//        assert teacher != null;
    }

    @Test
    public void deleteTechById() {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        teacherService teacherService = cpx.getBean("teacherService", teacherService.class);
        int isSuccess = teacherService.deleteTechById("10000005");
        System.out.println(isSuccess);
    }

    @Test
    public void insertTech() {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        teacherService teacherService = cpx.getBean("teacherService", teacherService.class);
        teacher teacher = new teacher("10000006","李四","信息学院",10000,"男");
        int isSuccess = teacherService.insertTech(teacher);
        System.out.println(isSuccess);
    }

    @Test
    public void findCourseById() {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        teacherService teacherService = cpx.getBean("teacherService", teacherService.class);
        List<course> course = teacherService.findCourseById("10000002");
        System.out.println(course);
        assert course != null;
    }
}