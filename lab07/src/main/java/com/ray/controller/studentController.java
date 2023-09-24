package com.ray.controller;

import com.ray.pojo.student;
import com.ray.service.studentService;
import com.ray.service.impl.studentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

    public void setStudentServiceImpl(studentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

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
}