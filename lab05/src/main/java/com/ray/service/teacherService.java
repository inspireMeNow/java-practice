package com.ray.service;

import com.ray.pojo.course;
import com.ray.pojo.teacher;

import java.util.List;

public interface teacherService {
    public  List<teacher> findAllTech();
    public  teacher findTechById(String id);
    public  int updateTechById(teacher teacher);
    public  int deleteTechById(String id);
    public  int insertTech(teacher teacher);
    public  List<course> findCourseById(String id);
}
