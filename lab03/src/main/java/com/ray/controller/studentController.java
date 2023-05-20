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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class studentController extends baseController {
    //    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//    {
//
//        // 实例化UserService
//        studentService studentService = new studentServiceImpl();
//
//        // 调用相应方法获得用户pojo
//        List<student> allUser = studentService.findAllStu();
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(JSON.toJSONString(allUser));
//        // 设置request属性
////        req.setAttribute("allstudent", allUser);
//
//        // 转发request和response
////        req.getRequestDispatcher("/index.jsp").forward(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
//    {
//        doGet(req, resp);
//    }
    protected void findAllStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService studentService = cpx.getBean("studentService", studentService.class);
        List<student> allUser = studentService.findAllStu();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(allUser));
    }

    protected void insertStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService studentService = cpx.getBean("studentService", studentService.class);
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String major = req.getParameter("major");
        String enrollment_date = req.getParameter("enrollment_date");
        student student = new student(id, name, major, enrollment_date, sex);
        int isSuccess = studentService.insertStu(student);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    protected void deleteStuById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService studentService = cpx.getBean("studentService", studentService.class);
        String id = req.getParameter("id");
        int isSuccess = studentService.deleteStuById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }
    protected void updateStuById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService studentService = cpx.getBean("studentService", studentService.class);
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String major = req.getParameter("major");
        String enrollment_date = req.getParameter("enrollment_date");
        student student = new student(id, name, major, enrollment_date, sex);
        int isSuccess = studentService.updateStuById(student);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    protected void findStuById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService studentService = cpx.getBean("studentService", studentService.class);
        String id = req.getParameter("id");
        student student = studentService.findStuById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(student));
    }
}