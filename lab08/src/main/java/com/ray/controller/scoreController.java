package com.ray.controller;

import com.alibaba.fastjson.JSON;
import com.ray.pojo.course;
import com.ray.pojo.score;
import com.ray.service.impl.scoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.swing.text.html.parser.Parser;
import java.io.IOException;
import java.util.List;
@CrossOrigin
@Controller
public class scoreController {
    @Autowired
    private scoreServiceImpl scoreService;
    @RequestMapping("/findAllScore")
    public void findAllScore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(scoreService.findAllScore()));
    }
    @RequestMapping("/findScoreByStu")
    public void findScoreByStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String student_id = req.getParameter("student_id");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(scoreService.findScoreByStu(student_id)));
    }
    @RequestMapping("/findScoreByCourse")
    public void findScoreByCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String course_id = req.getParameter("course_id");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(scoreService.findScoreByCourse(course_id)));
    }
@RequestMapping("/updateScore")
    public void updateScoreByStuCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String student_id = req.getParameter("student_id");
        String course_id = req.getParameter("course_id");
        String score = req.getParameter("score");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(scoreService.updateScoreByStuCourse(new score(student_id,course_id,score))));
    }
    @RequestMapping("/deleteScore")
    public void deleteScoreByStuCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String student_id = req.getParameter("student_id");
        String course_id = req.getParameter("course_id");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(scoreService.deleteScoreByStuCourse(new score(student_id,course_id,"0"))));
    }
    @RequestMapping("/deleteScoreByStu")
    public void deleteScoreByStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String student_id = req.getParameter("student_id");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(scoreService.deleteScoreByStu(student_id)));
    }
    @RequestMapping("/deleteScoreByCourse")
    public void deleteScoreByCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String course_id = req.getParameter("course_id");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(scoreService.deleteScoreByCourse(course_id)));
    }
    @RequestMapping("/insertScore")
    public void insertScoreByStuCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String student_id = req.getParameter("student_id");
        String course_id = req.getParameter("course_id");
        String score = req.getParameter("score");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(scoreService.insertScoreByStuCourse(new score(student_id,course_id, score))));
    }
    @RequestMapping("/findScoreByStuCourse")
    public void findScoreByStuCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String student_id = req.getParameter("student_id");
        String course_id = req.getParameter("course_id");
        String score = req.getParameter("score");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(scoreService.findScoreByStuCourse(new score(student_id,course_id,score))));
    }
}
