package com.ray.controller;

import com.alibaba.fastjson.JSON;
import com.ray.pojo.course;
import com.ray.service.impl.courseServiceImpl;
import com.ray.service.courseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class courseController extends baseController {
    public void findAllCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        courseService courseService = new courseServiceImpl();
        List<course> allUser = courseService.findAllCourse();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(allUser));
    }

    public void findCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        courseService courseService = new courseServiceImpl();
        String id = req.getParameter("id");
        course course = courseService.findCourseById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(course));
    }

    public void updateCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        courseService courseService = new courseServiceImpl();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        int semester = Integer.parseInt(req.getParameter("semester"));
        int credit = Integer.parseInt(req.getParameter("credit"));
        String teacher_id = req.getParameter("teacher_id");
        course course = new course(id, name, semester,credit,teacher_id);
        int isSuccess = courseService.updateCourseById(course);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    public void deleteCourseById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        courseService courseService = new courseServiceImpl();
        String id = req.getParameter("id");
        int isSuccess = courseService.deleteCourseById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    public void insertCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        courseService courseService = new courseServiceImpl();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        int semester = Integer.parseInt(req.getParameter("semester"));
        int credit = Integer.parseInt(req.getParameter("credit"));
        String teacher_id = req.getParameter("teacher_id");
        course course = new course(id, name, semester,credit,teacher_id);
        int isSuccess = courseService.insertCourse(course);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }
}
