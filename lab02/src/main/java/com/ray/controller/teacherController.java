package com.ray.controller;

import com.alibaba.fastjson.JSON;
import com.ray.pojo.teacher;


import com.ray.service.impl.teacherServiceImpl;
import com.ray.service.teacherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class teacherController extends baseController {
    public void findAllTech(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        teacherService teacherService = new teacherServiceImpl();
        List<teacher> allUser = teacherService.findAllTech();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(allUser));
    }

    public void findTechById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        teacherService teacherService = new teacherServiceImpl();
        String id = req.getParameter("id");
        teacher teacher = teacherService.findTechById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(teacher));
    }

    public void updateTechById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        teacherService teacherService = new teacherServiceImpl();
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

    public void deleteTechById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        teacherService teacherService = new teacherServiceImpl();
        String id = req.getParameter("id");
        int isSuccess = teacherService.deleteTechById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    public void insertTech(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        teacherService teacherService = new teacherServiceImpl();
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
}
