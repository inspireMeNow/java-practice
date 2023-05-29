package com.ray.controller;

import com.alibaba.fastjson.JSON;
import com.ray.pojo.teacher;


import com.ray.service.impl.teacherServiceImpl;
import com.ray.service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin
public class teacherController {
    @Autowired
    private teacherServiceImpl teacherService;
    

    @RequestMapping("/findAllTech")
    public void findAllTech(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<teacher> allTeacher = teacherService.findAllTech();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(allTeacher));
    }

    @RequestMapping("findTechById")
    public void findTechById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        teacher teacher = teacherService.findTechById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(teacher));
    }

    @RequestMapping("updateTechById")
    public void updateTechById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String department = req.getParameter("department");
        int salary = Integer.parseInt(req.getParameter("salary"));
        String sex = req.getParameter("sex");
        teacher teacher = new teacher(id, name, department, salary, sex);
        int isSuccess = teacherService.updateTechById(teacher);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @RequestMapping("/deleteTechById")
    public void deleteTechById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int isSuccess = teacherService.deleteTechById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @RequestMapping("/insertTech")
    public void insertTech(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String department = req.getParameter("department");
        int salary = Integer.parseInt(req.getParameter("salary"));
        String sex = req.getParameter("sex");
        teacher teacher = new teacher(id, name, department, salary, sex);
        int isSuccess = teacherService.insertTech(teacher);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }
    @RequestMapping("/findCourseByTech")
    public void findCourseByTech(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String teacher_id = req.getParameter("teacher");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(teacherService.findCourseById(teacher_id)));
    }
}
