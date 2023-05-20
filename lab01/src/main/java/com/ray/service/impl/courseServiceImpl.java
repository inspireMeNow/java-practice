package com.ray.service.impl;

import com.ray.dao.impl.courseDaoImpl;
import com.ray.dao.courseDao;
import com.ray.pojo.course;
import com.ray.service.courseService;

import java.util.List;

public class courseServiceImpl implements courseService {
    @Override
    public List<course> findAllCourse() {
        courseDao courseDao = new courseDaoImpl();
        return courseDao.findAllCourse();
    }

    @Override
    public course findCourseById(String id) {
        return new courseDaoImpl().findCourseById(id);
    }

    @Override
    public int updateCourseById(course course) {
        return new courseDaoImpl().updateCourseById(course);
    }

    @Override
    public int deleteCourseById(String id) {
        courseDao courseDao = new courseDaoImpl();
        if(courseDao.findCourseById(id).getId() != null){
            return courseDao.deleteCourseById(id);
        }
        return -1;
    }

    public int insertCourse(course course) {
        courseDao courseDao = new courseDaoImpl();
        if(courseDao.findCourseById(course.getId()).getId() == null){
            return courseDao.insertCourse(course);
        }
        return -1;
    }
}
