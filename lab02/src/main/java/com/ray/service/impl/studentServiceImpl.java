package com.ray.service.impl;

import com.ray.dao.studentDao;
import com.ray.pojo.student;
import com.ray.pojo.student;
import com.ray.service.studentService;
import com.ray.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class studentServiceImpl implements studentService {
    public List<student> findAllStu() {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            studentDao mapper = sqlSession.getMapper(studentDao.class);
            return mapper.findAllStu();
        }
    }

    public List<student> findStuByEnroll(String enroll) {
        return null;
    }

    public List<student> findStuByMajor(String major) {
        return null;
    }

    public student findStuById(String id) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            studentDao mapper = sqlSession.getMapper(studentDao.class);
            return mapper.findStuById(id);
        }
    }

    public int updateStuById(student student) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            studentDao mapper = sqlSession.getMapper(studentDao.class);
            if (mapper.findStuById(student.getId()) == null) {
                return -1;
            }
            int isSuccess = mapper.updateStuById(student);
            sqlSession.commit();
            sqlSession.close();
            return isSuccess;
        }
    }

    public int deleteStuById(String id) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            studentDao mapper = sqlSession.getMapper(studentDao.class);
            if (mapper.findStuById(id) == null) {
                return -1;
            }
            int isSuccess = mapper.deleteStuById(id);
            sqlSession.commit();
            sqlSession.close();
            return isSuccess;
        }
    }

    public int insertStu(student student) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            studentDao mapper = sqlSession.getMapper(studentDao.class);
            if (mapper.findStuById(student.getId()) == null) {
                int isSuccess = mapper.insertStu(student);
                sqlSession.commit();
                sqlSession.close();
                return isSuccess;
            }
            return -1;
        }
    }
}
