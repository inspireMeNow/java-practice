package com.ray.service;

import com.ray.pojo.course;
import com.ray.pojo.student;
import com.ray.pojo.teacher;

import java.util.List;

public interface courseService {
    public List<course> findAllCourse();

    public course findCourseById(String id);

    public int updateCourseById(course course);

    public int deleteCourseById(String id);

    public int insertCourse(course course);
    public List<course> findCourseByTech(String teacher);
}
