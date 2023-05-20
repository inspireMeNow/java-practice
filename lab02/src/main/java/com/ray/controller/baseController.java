package com.ray.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class baseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("utf-8");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
//        resp.setHeader("Access-Control-Allow-Origin", "*");
//        /* 允许跨域的请求方法GET, POST, HEAD 等 */
//        resp.setHeader("Access-Control-Allow-Methods", "*");
//        /* 重新预检验跨域的缓存时间 (s) */
//        resp.setHeader("Access-Control-Max-Age", "4200");
//        /* 允许跨域的请求头 */
//        resp.setHeader("Access-Control-Allow-Headers", "*");
//        /* 是否携带cookie */
//        resp.setHeader("Access-Control-Allow-Credentials", "true");
        try {
            //获取action业务鉴别字符串，获取相应的业务，方法反射对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标业务方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Filter过滤器
        }
    }
}
