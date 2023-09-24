package com.ray.controller;

import com.alibaba.fastjson.JSON;
import com.ray.pojo.user;
import com.ray.service.impl.passwordServiceImpl;
import com.ray.service.impl.userServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@Controller
public class userController {
    @Autowired
    private userServiceImpl userServiceImpl;

    @RequestMapping("/findAllUser")
    protected void findAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<user> allUser = userServiceImpl.findAllUser();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(allUser));
    }

    @RequestMapping("/insertUser")
    protected void insertUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int idtype = Integer.parseInt(req.getParameter("idtype"));
        user user = new user(id, email, password, idtype);
        int isSuccess = userServiceImpl.insertUser(user);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @RequestMapping("/deleteUserById")
    protected void deleteUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int isSuccess = userServiceImpl.deleteUserById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @RequestMapping("/updateUserById")
    protected void updateUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int idtype = Integer.parseInt(req.getParameter("idtype"));
        user user = new user(id, email, password, idtype);
        int isSuccess = userServiceImpl.updateUserById(user);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(isSuccess));
    }

    @RequestMapping("findUserById")
    protected void findUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        user user = userServiceImpl.findUserById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(JSON.toJSONString(user));
    }

    @RequestMapping("/login")
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        int idtype = Integer.parseInt(req.getParameter("idtype"));
        int isLogin = userServiceImpl.login(new user(id, " ", password, idtype));
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
//        if(isLogin == 1){
//            UUID uuid = UUID.randomUUID();
//            resp.addCookie(new Cookie("token", uuid.toString()));
//        }
//        String token = req.getHeader("Authorization");
        resp.getWriter().write(JSON.toJSONString(isLogin));
    }
}
