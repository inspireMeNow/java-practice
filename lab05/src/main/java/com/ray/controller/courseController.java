package com.ray.controller;

import com.alibaba.fastjson.JSON;
import com.ray.pojo.course;
import com.ray.service.impl.courseServiceImpl;
import com.ray.service.courseService;
import com.ray.service.impl.studentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@Controller
public class courseController {
    @RequestMapping("/findAllCourse")
    public void findAllCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<course> allUser = courseService.findAllCourse();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(allUser));
    }

    @RequestMapping("/findCourseById")
    public void findCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        course course = courseService.findCourseById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(course));
    }

    @RequestMapping("/updateCourseById")
    public void updateCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        int semester = Integer.parseInt(req.getParameter("semester"));
        int credit = Integer.parseInt(req.getParameter("credit"));
        String teacher_id = req.getParameter("teacher_id");
        course course = new course(id, name, semester, credit, teacher_id);
        int isSuccess = courseService.updateCourseById(course);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @RequestMapping("/deleteCourseById")
    public void deleteCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int isSuccess = courseService.deleteCourseById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @RequestMapping("/insertCourse")
    public void insertCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        int semester = Integer.parseInt(req.getParameter("semester"));
        int credit = Integer.parseInt(req.getParameter("credit"));
        String teacher_id = req.getParameter("teacher_id");
        course course = new course(id, name, semester, credit, teacher_id);
        int isSuccess = courseService.insertCourse(course);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @Autowired
    private courseServiceImpl courseService;
}
