package com.ray.dao.impl;

import com.ray.dao.teacherDao;
import com.ray.pojo.teacher;
import com.ray.pojo.teacher;
import com.ray.utils.JDBCUtils;

import javax.swing.text.html.parser.Parser;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class teacherDaoImpl implements teacherDao {
    public List<teacher> findAllTech() {
        List<teacher> data = new ArrayList<>();
        Connection con = JDBCUtils.getConnection();
        String str = "select * from teacher ";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(str);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                teacher tmp = new teacher();
                tmp.setId(res.getString("id"));
                tmp.setName(res.getString("name"));
                tmp.setDepartment(res.getString("department"));
                tmp.setSalary(Integer.parseInt(res.getString("salary")));
                tmp.setsex(res.getString("sex"));
                data.add(tmp);
            }
            JDBCUtils.close(con, preparedStatement, res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public teacher findTechById(String id) {
        Connection con = JDBCUtils.getConnection();
        String str = "select * from teacher where id='" + id + "'";
        teacher tmp = new teacher();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(str);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                tmp.setId(res.getString("id"));
                tmp.setName(res.getString("name"));
                tmp.setDepartment(res.getString("department"));
                tmp.setSalary(Integer.parseInt(res.getString("salary")));
                tmp.setsex(res.getString("sex"));
            }
            JDBCUtils.close(con, preparedStatement, res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tmp;
    }

    public int updateTechById(teacher teacher) {
        Connection con = JDBCUtils.getConnection();
        String str = "update teacher set name = '" + teacher.getName() + "', department = '" + teacher.getDepartment() + "', salary = " + teacher.getSalary() + ", sex = '" + teacher.getsex() + "'" +
                "where id = '" + teacher.getId() + "'";
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

    public int deleteTechById(String id) {
        Connection con = JDBCUtils.getConnection();
        String str = "delete from teacher where id = '" + id + "'";
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

    public int insertTech(teacher teacher) {
        Connection con = JDBCUtils.getConnection();
        String str = "insert into teacher values('" + teacher.getId() + "', '" + teacher.getName() + "', '" + teacher.getDepartment() + "', " + teacher.getSalary() + ", '" + teacher.getsex() + "')";
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
