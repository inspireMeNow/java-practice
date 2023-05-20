package com.ray.service.impl;

import com.ray.dao.courseDao;
import com.ray.pojo.course;
import com.ray.pojo.course;
import com.ray.service.courseService;
import com.ray.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class courseServiceImpl implements courseService {
    public List<course> findAllCourse() {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            courseDao mapper = sqlSession.getMapper(courseDao.class);
            return mapper.findAllCourse();
        }
    }

    public course findCourseById(String id) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            courseDao mapper = sqlSession.getMapper(courseDao.class);
            return mapper.findCourseById(id);
        }
    }

    public int updateCourseById(course course) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            courseDao mapper = sqlSession.getMapper(courseDao.class);
            if (mapper.findCourseById(course.getId()) == null) {
                return -1;
            }
            int isSuccess = mapper.updateCourseById(course);
            sqlSession.commit();
            sqlSession.close();
            return isSuccess;
        }
    }

    public int deleteCourseById(String id) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            courseDao mapper = sqlSession.getMapper(courseDao.class);
            if (mapper.findCourseById(id) == null) {
                return -1;
            }
            int isSuccess = mapper.deleteCourseById(id);
            sqlSession.commit();
            sqlSession.close();
            return isSuccess;
        }
    }

    public int insertCourse(course course) {
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()) {
            assert sqlSession != null;
            courseDao mapper = sqlSession.getMapper(courseDao.class);
            if (mapper.findCourseById(course.getId()) == null) {
                int isSuccess = mapper.insertCourse(course);
                sqlSession.commit();
                sqlSession.close();
                return isSuccess;
            }
            return -1;
        }
    }
}
