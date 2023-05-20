package com.ray.service.impl;

import com.ray.dao.courseDao;
import com.ray.dao.teacherDao;
import com.ray.pojo.course;
import com.ray.pojo.teacher;

import com.ray.service.teacherService;


import java.util.List;


public class teacherServiceImpl implements teacherService {
    teacherDao teacherDao;
    courseDao courseDao;

    public void setTeacherDao(teacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public List<teacher> findAllTech() {
        return teacherDao.findAllTech();
    }

    public List<teacher> findTechByEnroll(String enroll) {
        return null;
    }

    public List<teacher> findTechByMajor(String major) {
        return null;
    }

    public teacher findTechById(String id) {
        return teacherDao.findTechById(id);
    }

    public int updateTechById(teacher teacher) {
        if (teacherDao.findTechById(teacher.getId()) == null) {
            return -1;
        }
        return teacherDao.updateTechById(teacher);
    }

    public int deleteTechById(String id) {
        if (teacherDao.findTechById(id) == null) {
            return -1;
        }
        if(teacherDao.deleteTechById(id) >= 1){
            if(courseDao.deleteCourseByTech(id) >=1){
                return 1;
            }
            return -1;
        }
        return -1;
    }

    public int insertTech(teacher teacher) {
        if (teacherDao.findTechById(teacher.getId()) == null) {
            return teacherDao.insertTech(teacher);
        }
        return -1;
    }
    public List<course> findCourseById(String id){
        return teacherDao.findCourseById(id);
    }

    public void setCourseDao(courseDao courseDao) {
        this.courseDao = courseDao;
    }
}
