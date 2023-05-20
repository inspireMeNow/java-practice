package com.ray.service;

import com.ray.pojo.course;
import com.ray.pojo.teacher;

import java.util.List;

public interface courseService {
    public abstract List<course> findAllCourse();
    public abstract course findCourseById(String id);
    public abstract int updateCourseById(course course);
    public abstract int deleteCourseById(String id);
    public abstract int insertCourse(course course);
}
