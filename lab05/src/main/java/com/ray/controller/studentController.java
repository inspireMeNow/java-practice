package com.ray.controller;

import com.ray.pojo.score;
import com.ray.pojo.student;
import com.ray.service.studentService;
import com.ray.service.impl.studentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class studentController {
    @Autowired
    private studentServiceImpl studentServiceImpl;
//    public void setStudentServiceImpl(studentServiceImpl studentServiceImpl)
//    {
//        this.studentServiceImpl = studentServiceImpl;
//    }

    @RequestMapping("/findAllStu")
    protected void findAllStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<student> allUser = studentServiceImpl.findAllStu();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(allUser));
    }

    @RequestMapping("/insertStu")
    protected void insertStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String major = req.getParameter("major");
        String enrollment_date = req.getParameter("enrollment_date");
        student student = new student(id, name, major, enrollment_date, sex);
        int isSuccess = studentServiceImpl.insertStu(student);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @RequestMapping("/deleteStuById")
    protected void deleteStuById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int isSuccess = studentServiceImpl.deleteStuById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @RequestMapping("/updateStuById")
    protected void updateStuById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String major = req.getParameter("major");
        String enrollment_date = req.getParameter("enrollment_date");
        student student = new student(id, name, major, enrollment_date, sex);
        int isSuccess = studentServiceImpl.updateStuById(student);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @RequestMapping("findStuById")
    protected void findStuById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        student student = studentServiceImpl.findStuById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(student));
    }

    @RequestMapping("/findCourseByStu")
    protected void findCourseByStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("student");
        List<score> course = studentServiceImpl.findCourseByStu(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(course));
    }
}