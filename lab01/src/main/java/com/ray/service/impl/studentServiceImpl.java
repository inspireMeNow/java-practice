package com.ray.service.impl;

import com.ray.dao.studentDao;
import com.ray.pojo.student;
import com.ray.service.studentService;

import java.util.List;
import com.ray.dao.impl.studentDaoImpl;

public class studentServiceImpl implements studentService {
    @Override
    public List<student> findAllStu() {
        studentDao studentDao = new studentDaoImpl();
        return studentDao.findAllStu();
    }

    @Override
    public student findStuById(String id) {
        return new studentDaoImpl().findStuById(id);
    }

    @Override
    public List<student> findStuByEnroll(String enroll) {
        return new studentDaoImpl().findStuByEnroll(enroll);
    }

    @Override
    public List<student> findStuByMajor(String major) {
        return new studentDaoImpl().findStuByMajor(major);
    }

    @Override
    public int updateStuById(student student) {
        return new studentDaoImpl().updateStuById(student);
    }

    @Override
    public int deleteStuById(String id) {
        studentDao studentDao = new studentDaoImpl();
        if(studentDao.findStuById(id).getId() != null){
            return studentDao.deleteStuById(id);
        }
        return -1;
    }

    public int insertStu(student student) {
        studentDao studentDao = new studentDaoImpl();
        if(studentDao.findStuById(student.getId()).getId() == null){
            return studentDao.insertStu(student);
        }
        return -1;
    }
}
