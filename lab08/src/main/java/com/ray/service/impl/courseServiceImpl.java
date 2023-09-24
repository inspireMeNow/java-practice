package com.ray.service.impl;

import com.ray.dao.courseDao;
import com.ray.dao.scoreDao;
import com.ray.dao.teacherDao;
import com.ray.pojo.course;
import com.ray.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseServiceImpl implements courseService {
    @Autowired
    courseDao courseDao;
    @Autowired
    teacherDao teacherDao;
    @Autowired
    scoreDao scoreDao;

    @Override
    public List<course> findAllCourse() {
        return courseDao.findAllCourse();
    }

    public List<course> findCourseByEnroll(String enroll) {
        return null;
    }

    public List<course> findCourseByMajor(String major) {
        return null;
    }

    @Override
    public course findCourseById(String id) {
        return courseDao.findCourseById(id);
    }

    @Override
    public int updateCourseById(course course) {
        if (courseDao.findCourseById(course.getId()) == null) {
            return -1;
        }
        if (teacherDao.findTechById(course.getTeacher_id()) == null) {
            return -1;
        }
        return courseDao.updateCourseById(course);
    }

    @Override
    public int deleteCourseById(String id) {
        if (courseDao.findCourseById(id) == null) {
            return -1;
        }
        scoreDao.deleteScoreByCourse(id);
        return courseDao.deleteCourseById(id);
    }

    @Override
    public int insertCourse(course course) {
        if (courseDao.findCourseById(course.getId()) == null) {
            if (teacherDao.findTechById(course.getTeacher_id()) != null) {
                return courseDao.insertCourse(course);
            }
            return -1;
        }
        return -1;
    }

    public List<course> findCourseByTech(String teacher) {
        return courseDao.findCourseByTech(teacher);
    }
}
