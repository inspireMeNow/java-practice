package com.ray.dao;

import com.ray.pojo.teacher;
import com.ray.pojo.course;
import java.util.List;

public interface courseDao {
    public abstract List<course> findAllCourse();
    public abstract course findCourseById(String id);
    public abstract int updateCourseById(course course);
    public abstract int deleteCourseById(String id);
    public abstract int insertCourse(course course);
}
