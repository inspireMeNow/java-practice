package com.ray.service.impl;

import com.ray.dao.impl.teacherDaoImpl;
import com.ray.pojo.teacher;
import com.ray.dao.teacherDao;
import com.ray.service.teacherService;

import java.util.List;

public class teacherServiceImpl implements teacherService {
    public List<teacher> findAllTech() {
        teacherDao teacherDao = new teacherDaoImpl();
        return teacherDao.findAllTech();
    }

    public teacher findTechById(String id) {
        return new teacherDaoImpl().findTechById(id);
    }

    public int updateTechById(teacher teacher) {
        teacherDao teacherDao = new teacherDaoImpl();
        if (teacherDao.findTechById(teacher.getId()).getId() == null) {
            return -1;
        }
        return teacherDao.updateTechById(teacher);
    }

    public int deleteTechById(String id) {
        teacherDao teacherDao = new teacherDaoImpl();
        if (teacherDao.findTechById(id).getId() == null) {
            return -1;
        }
        return teacherDao.deleteTechById(id);
    }

    public int insertTech(teacher teacher) {
        teacherDao teacherDao = new teacherDaoImpl();
        if (teacherDao.findTechById(teacher.getId()).getId() == null) {
            return teacherDao.insertTech(teacher);
        }
        return -1;
    }
}
