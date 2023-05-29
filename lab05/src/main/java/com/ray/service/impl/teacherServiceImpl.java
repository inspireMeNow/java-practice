package com.ray.service.impl;

import com.ray.dao.courseDao;
import com.ray.dao.teacherDao;
import com.ray.pojo.course;
import com.ray.pojo.teacher;

import com.ray.service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Iterator;
import java.util.List;

@Service
public class teacherServiceImpl implements teacherService {
    @Autowired
    teacherDao teacherDao;
    @Autowired
    courseDao courseDao;

    @Override
    public List<teacher> findAllTech() {
        return teacherDao.findAllTech();
    }

    @Override

    public teacher findTechById(String id) {
        return teacherDao.findTechById(id);
    }

    @Override
    public int updateTechById(teacher teacher) {
        if (teacherDao.findTechById(teacher.getId()) == null) {
            return -1;
        }
        return teacherDao.updateTechById(teacher);
    }

    @Override
    public int deleteTechById(String id) {
        if (teacherDao.findTechById(id) == null) {
            return -1;
        }
        if(teacherDao.deleteTechById(id) == 1){
            List<course> courseList = courseDao.findCourseByTech(id);
            for (course course : courseList) {
                course.setTeacher_id(id + "(已离职)");
                courseDao.updateCourseById(course);
            }
            return 1;
        }
        return -1;
    }

    @Override
    public int insertTech(teacher teacher) {
        if (teacherDao.findTechById(teacher.getId()) == null) {
            return teacherDao.insertTech(teacher);
        }
        return -1;
    }

    @Override
    public List<course> findCourseById(String id) {
        return teacherDao.findCourseById(id);
    }

}
