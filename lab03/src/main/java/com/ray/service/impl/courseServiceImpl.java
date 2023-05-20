package com.ray.service.impl;

import com.ray.dao.courseDao;
import com.ray.pojo.course;
import com.ray.service.courseService;
import java.util.List;

public class courseServiceImpl implements courseService {
    com.ray.dao.courseDao courseDao;

    public void setCourseDao(courseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<course> findAllCourse() {
        return courseDao.findAllCourse();
    }

    public List<course> findCourseByEnroll(String enroll) {
        return null;
    }

    public List<course> findCourseByMajor(String major) {
        return null;
    }

    public course findCourseById(String id) {
        return courseDao.findCourseById(id);
    }

    public int updateCourseById(course course) {
        if (courseDao.findCourseById(course.getId()) == null) {
            return -1;
        }
        return courseDao.updateCourseById(course);
    }

    public int deleteCourseById(String id) {
        if (courseDao.findCourseById(id) == null) {
            return -1;
        }
        return courseDao.deleteCourseById(id);
    }

    public int insertCourse(course course) {
        if (courseDao.findCourseById(course.getId()) == null) {
            return courseDao.insertCourse(course);
        }
        return -1;
    }
}
