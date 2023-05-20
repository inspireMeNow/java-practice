package com.ray.dao;

import com.ray.pojo.student;

import java.util.List;

public interface studentDao {
    public List<student> findAllStu();

    public student findStuById(String id);

    public List<student> findStuByEnroll(String enroll);

    public List<student> findStuByMajor(String major);

    public int updateStuById(student student);

    public int deleteStuById(String id);

    public int insertStu(student student);

}
