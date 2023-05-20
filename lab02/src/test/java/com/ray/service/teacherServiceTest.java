package com.ray.service;

import com.ray.dao.teacherDao;
import com.ray.pojo.course;
import com.ray.pojo.teacher;
import com.ray.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import com.ray.service.impl.teacherServiceImpl;
public class teacherServiceTest
{
    @Test
    public void findTechById()
    {
        teacherService teacherService = new teacherServiceImpl();
        teacher teacher = teacherService.findTechById("10000001");
        System.out.println(teacher.toString());
        assert teacher != null;
    }
    @Test
    public void findAllTech()
    {
        teacherService teacherService = new teacherServiceImpl();
        List<teacher> teacher = teacherService.findAllTech();
        System.out.println(teacher.toString());
        assert teacher != null;
    }

    @Test
    public void updateTechById() {
        teacherService teacherService = new teacherServiceImpl();
        teacher teacher = new teacher("10000004","scd","信息学院",10000,"男");
        int isSuccess = teacherService.updateTechById(teacher);
        System.out.println(isSuccess);
//        assert teacher != null;
    }

    @Test
    public void deleteTechById() {
        teacherService teacherService = new teacherServiceImpl();
        int isSuccess = teacherService.deleteTechById("10000005");
        System.out.println(isSuccess);
    }

    @Test
    public void insertTech() {
        teacherService teacherService = new teacherServiceImpl();
        teacher teacher = new teacher("10000006","李四","信息学院",10000,"男");
        int isSuccess = teacherService.insertTech(teacher);
        System.out.println(isSuccess);
    }

    @Test
    public void findCourseById() {
        teacherService teacherService = new teacherServiceImpl();
        List<course> course = teacherService.findCourseById("10000002");
        System.out.println(course);
        assert course != null;
    }
}