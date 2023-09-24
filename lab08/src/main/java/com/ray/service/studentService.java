package com.ray.service;

import com.ray.pojo.score;
import com.ray.pojo.student;

import java.util.List;

public interface studentService {
    public  List<student> findAllStu();
    public  student findStuById(String id);
    public  List<student> findStuByEnroll(String enroll);
    public  List<student> findStuByMajor(String major);
    public  int updateStuById(student student);
    public  int deleteStuById(String id);
    public  int insertStu(student student);
    public List<score> findCourseByStu(String id);
}
