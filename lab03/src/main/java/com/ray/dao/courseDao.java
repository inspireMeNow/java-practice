package com.ray.dao;

import com.ray.pojo.teacher;
import com.ray.pojo.course;
import java.util.List;

public interface courseDao {
    public List<course> findAllCourse();
    public course findCourseById(String id);
    public int updateCourseById(course course);
    public int deleteCourseById(String id);
    public int insertCourse(course course);
}
