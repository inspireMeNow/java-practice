package com.ray.service.impl;

import com.ray.dao.studentDao;
import com.ray.pojo.student;

import com.ray.service.studentService;


import java.util.List;

public class studentServiceImpl implements studentService {
    studentDao studentDao;

    public void setStudentDao(studentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<student> findAllStu() {
        return studentDao.findAllStu();
    }

    public List<student> findStuByEnroll(String enroll) {
        return null;
    }

    public List<student> findStuByMajor(String major) {
        return null;
    }

    public student findStuById(String id) {
        return studentDao.findStuById(id);
    }

    public int updateStuById(student student) {
        if (studentDao.findStuById(student.getId()) == null) {
            return -1;
        }
        return studentDao.updateStuById(student);
    }

    public int deleteStuById(String id) {
        if (studentDao.findStuById(id) == null) {
            return -1;
        }
        return studentDao.deleteStuById(id);
    }

    public int insertStu(student student) {
        if (studentDao.findStuById(student.getId()) == null) {
            return studentDao.insertStu(student);
        }
        return -1;
    }
}
