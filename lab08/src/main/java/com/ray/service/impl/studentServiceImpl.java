package com.ray.service.impl;

import com.ray.dao.studentDao;
import com.ray.dao.scoreDao;
import com.ray.pojo.score;
import com.ray.pojo.student;

import com.ray.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class studentServiceImpl implements studentService {
    @Autowired
    studentDao studentDao;
    @Autowired
    scoreDao scoreDao;

    @Override

    public List<student> findAllStu() {
        return studentDao.findAllStu();
    }

    @Override
    public List<student> findStuByEnroll(String enroll) {
        return null;
    }

    @Override
    public List<student> findStuByMajor(String major) {
        return null;
    }

    @Override
    public student findStuById(String id) {
        return studentDao.findStuById(id);
    }

    @Override
    public List<score> findCourseByStu(String id) {
        return studentDao.findCourseByStu(id);
    }

    @Override
    public int updateStuById(student student) {
        if (studentDao.findStuById(student.getId()) == null) {
            return -1;
        }
        return studentDao.updateStuById(student);
    }

    @Override
    public int deleteStuById(String id) {
        if (studentDao.findStuById(id) == null) {
            return -1;
        }
        if (studentDao.deleteStuById(id) == 1) {
            if (scoreDao.deleteScoreByStu(id) >= 1) {
                return 1;
            }
            return -1;
        }
        return -1;
    }

    @Override
    public int insertStu(student student) {
        if (studentDao.findStuById(student.getId()) == null) {
            return studentDao.insertStu(student);
        }
        return -1;
    }
}
