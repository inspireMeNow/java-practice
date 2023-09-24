package com.ray.service;

import com.ray.pojo.student;
import com.ray.pojo.student;
import com.ray.service.impl.studentServiceImpl;
import com.ray.service.impl.studentServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class studentServiceImplTest {

    @Test
    public void findAllStu() {
        studentService studentService = new studentServiceImpl();
        List<student> student = studentService.findAllStu();
        System.out.println(student);
        assert student != null;
    }

    @Test
    public void findStuById() {
        studentService studentService = new studentServiceImpl();
        student student = studentService.findStuById("20204124");
        System.out.println(student.toString());
        assert student != null;
    }

    @Test
    public void updateStuById() {
        studentService studentService = new studentServiceImpl();
        student student = new student("20204102","李四","信息学院","2022-09-01","男");
        int isSuccess = studentService.updateStuById(student);
        System.out.println(isSuccess);
    }

    @Test
    public void deleteStuById() {
        studentService studentService = new studentServiceImpl();
        int isSuccess = studentService.deleteStuById("20204123");
        System.out.println(isSuccess);
    }

    @Test
    public void insertStu() {
        studentService studentService = new studentServiceImpl();
        student student = new student("20204127","asdswda","信息学院","2021-09-01","男");
        int isSuccess = studentService.insertStu(student);
        System.out.println(isSuccess);
    }
}