package com.ray.dao.impl;

import com.ray.dao.courseDao;
import com.ray.pojo.course;
import com.ray.pojo.course;
import com.ray.pojo.teacher;
import com.ray.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class courseDaoImpl implements courseDao {
    @Override
    public List<course> findAllCourse() {
        List<course> data = new ArrayList<>();
        Connection con = JDBCUtils.getConnection();
        String str = "select * from course ";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(str);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                course tmp = new course();
                tmp.setId(res.getString("id"));
                tmp.setName(res.getString("name"));
                tmp.setSemester(Integer.parseInt(res.getString("semester")));
                tmp.setCredit(Integer.parseInt(res.getString("credit")));
                tmp.setTeacher_id(res.getString("teacher_id"));
                data.add(tmp);
            }
            JDBCUtils.close(con, preparedStatement, res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public course findCourseById(String id) {
        Connection con = JDBCUtils.getConnection();
        String str = "select * from course where id='" + id + "'";
        course tmp = new course();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(str);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                tmp.setId(res.getString("id"));
                tmp.setName(res.getString("name"));
                tmp.setSemester(Integer.parseInt(res.getString("semester")));
                tmp.setCredit(Integer.parseInt(res.getString("credit")));
                tmp.setTeacher_id(res.getString("teacher_id"));
            }
            JDBCUtils.close(con, preparedStatement, res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tmp;
    }


    @Override
    public int updateCourseById(course course) {
        Connection con = JDBCUtils.getConnection();
        String str = "update course set name = '" + course.getName() + "', semester = " + course.getSemester() + ", credit = " + course.getCredit() + ", teacher_id = '" + course.getTeacher_id() + "'" +
                "where id = '" + course.getId() + "'";
        int result = 0;
        try {
            Statement statement = con.createStatement();
            result = statement.executeUpdate(str);
            JDBCUtils.close(con, statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int deleteCourseById(String id) {
        Connection con = JDBCUtils.getConnection();
        String str = "delete from course where id = '" + id + "'";
        int result = 0;
        try {
            Statement statement = con.createStatement();
            result = statement.executeUpdate(str);
            JDBCUtils.close(con, statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int insertCourse(course course) {
        Connection con = JDBCUtils.getConnection();
        String str = "insert into course values('"+course.getId()+"', '"+course.getName()+"', "+course.getSemester()+", "+course.getCredit()+", '"+course.getTeacher_id()+"')";
        int result = 0;
        try {
            Statement statement = con.createStatement();
            result = statement.executeUpdate(str);
            JDBCUtils.close(con, statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
