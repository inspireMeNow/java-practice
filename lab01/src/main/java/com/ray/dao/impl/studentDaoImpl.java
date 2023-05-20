package com.ray.dao.impl;

import com.ray.pojo.student;
import com.ray.utils.JDBCUtils;
import com.ray.dao.studentDao;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
public class studentDaoImpl implements studentDao {
    @Override
    public List<student> findAllStu() {
        List<student> data = new ArrayList<>();
        Connection con = JDBCUtils.getConnection();
        String str = "select * from student ";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(str);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                student tmp = new student();
                tmp.setId(res.getString("id"));
                tmp.setName(res.getString("name"));
                tmp.setMajor(res.getString("major"));
                tmp.setEnrollment_date(res.getString("enrollment_date"));
                tmp.setSex(res.getString("sex"));
                data.add(tmp);
            }
            JDBCUtils.close(con, preparedStatement, res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public student findStuById(String id) {
        Connection con = JDBCUtils.getConnection();
        String str = "select * from student where id='" + id + "'";
        student tmp = new student();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(str);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                tmp.setId(res.getString("id"));
                tmp.setName(res.getString("name"));
                tmp.setMajor(res.getString("major"));
                tmp.setEnrollment_date(res.getString("enrollment_date"));
                tmp.setSex(res.getString("sex"));
            }
            JDBCUtils.close(con, preparedStatement, res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tmp;
    }

    @Override
    public List<student> findStuByEnroll(String enroll) {
        List<student> data = new ArrayList<>();
        Connection con = JDBCUtils.getConnection();
        String str = "select * from student where enrollment_date = '" + enroll + "'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(str);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                student tmp = new student();
                tmp.setId(res.getString("id"));
                tmp.setName(res.getString("name"));
                tmp.setMajor(res.getString("major"));
                tmp.setEnrollment_date(res.getString("enrollment_date"));
                tmp.setSex(res.getString("sex"));
                data.add(tmp);
            }
            JDBCUtils.close(con, preparedStatement, res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public List<student> findStuByMajor(String major) {
        List<student> data = new ArrayList<>();
        Connection con = JDBCUtils.getConnection();
        String str = "select * from student where major = '" + major + "'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(str);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                student tmp = new student();
                tmp.setId(res.getString("id"));
                tmp.setName(res.getString("name"));
                tmp.setMajor(res.getString("major"));
                tmp.setEnrollment_date(res.getString("enrollment_date"));
                tmp.setSex(res.getString("sex"));
                data.add(tmp);
            }
            JDBCUtils.close(con, preparedStatement, res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public int updateStuById(student student) {
        Connection con = JDBCUtils.getConnection();
        String str = "update student set name = '" + student.getName() + "', sex = '" + student.getSex() + "', major = '" + student.getMajor() + "', enrollment_date = '" + student.getEnrollment_date() + "'" +
                "where id = '" + student.getId() + "'";
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
    public int deleteStuById(String id) {
        Connection con = JDBCUtils.getConnection();
        String str = "delete from student where id = '" + id + "'";
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

    public int insertStu(student student) {
        Connection con = JDBCUtils.getConnection();
        String str = "insert into student values('"+student.getId()+"', '"+student.getName()+"', '"+student.getMajor()+"', '"+student.getEnrollment_date()+"', '"+student.getSex()+"')";
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
