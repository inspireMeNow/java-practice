package com.ray.service.impl;

import com.ray.pojo.course;
import com.ray.pojo.teacher;
import com.ray.dao.teacherDao;
import com.ray.service.teacherService;
import com.ray.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class teacherServiceImpl implements teacherService {
    public List<teacher> findAllTech() {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            teacherDao mapper = sqlSession.getMapper(teacherDao.class);
            return mapper.findAllTech();
        }
    }

    public teacher findTechById(String id) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            teacherDao mapper = sqlSession.getMapper(teacherDao.class);
            return mapper.findTechById(id);
        }
    }

    public int updateTechById(teacher teacher) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            teacherDao mapper = sqlSession.getMapper(teacherDao.class);
            if (mapper.findTechById(teacher.getId()) == null) {
                return -1;
            }
            int isSuccess = mapper.updateTechById(teacher);
            sqlSession.commit();
            sqlSession.close();
            return isSuccess;
        }
    }

    public int deleteTechById(String id) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            teacherDao mapper = sqlSession.getMapper(teacherDao.class);
            if (mapper.findTechById(id) == null) {
                return -1;
            }
            int isSuccess = mapper.deleteTechById(id);
            sqlSession.commit();
            sqlSession.close();
            return isSuccess;
        }
    }

    public int insertTech(teacher teacher) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            teacherDao mapper = sqlSession.getMapper(teacherDao.class);
            if (mapper.findTechById(teacher.getId()) == null) {
                int isSuccess = mapper.insertTech(teacher);
                sqlSession.commit();
                sqlSession.close();
                return isSuccess;
            }
            return -1;
        }
    }
    public List<course> findCourseById(String id){
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            teacherDao mapper = sqlSession.getMapper(teacherDao.class);
            return mapper.findCourseById(id);
        }
    }
}
