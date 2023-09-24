package com.ray.service.impl;

import com.ray.dao.courseDao;
import com.ray.dao.studentDao;
import com.ray.pojo.course;
import com.ray.pojo.score;
import com.ray.dao.scoreDao;
import com.ray.service.scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class scoreServiceImpl implements scoreService {
    @Autowired
    scoreDao scoreDao;
    @Autowired
    studentDao studentDao;
    @Autowired
    courseDao courseDao;

    @Override
    public List<score> findAllScore() {
        return scoreDao.findAllScore();
    }

    @Override
    public List<score> findScoreByStu(String student) {
        return scoreDao.findScoreByStu(student);
    }

    @Override
    public List<score> findScoreByCourse(String course) {
        return scoreDao.findScoreByCourse(course);
    }

    @Override
    public score findScoreByStuCourse(score score) {
        return scoreDao.findScoreByStuCourse(score);
    }

    @Override
    public int updateScoreByStuCourse(score score) {
        if (scoreDao.findScoreByStuCourse(score) != null) {
            if (studentDao.findStuById(score.getStudent_id()) != null) {
                if (courseDao.findCourseById(score.getCourse_id()) != null) {
                    return scoreDao.updateScoreByStuCourse(score);
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    @Override
    public int deleteScoreByStuCourse(score score) {
        if (scoreDao.findScoreByStuCourse(score) == null) {
            return -1;
        }
        return scoreDao.deleteScoreByStuCourse(score);
    }

    @Override
    public int deleteScoreByStu(String student) {
        if (scoreDao.findScoreByStu(student) == null) {
            return -1;
        }
        return scoreDao.deleteScoreByStu(student);
    }

    @Override
    public int deleteScoreByCourse(String course) {
        if (scoreDao.findScoreByCourse(course) == null) {
            return -1;
        }
        return scoreDao.deleteScoreByCourse(course);
    }

    @Override
    public int insertScoreByStuCourse(score score) {
        if (scoreDao.findScoreByStuCourse(score) == null) {
            if (studentDao.findStuById(score.getStudent_id()) != null){
                if(courseDao.findCourseById(score.getCourse_id())!=null){
                    return scoreDao.insertScoreByStuCourse(score);
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }
}
