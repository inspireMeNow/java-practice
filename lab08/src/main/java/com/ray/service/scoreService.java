package com.ray.service;

import com.ray.pojo.course;
import com.ray.pojo.score;

import java.util.List;

public interface scoreService {
    public List<score> findAllScore();
    public List<score> findScoreByStu(String student);
    public List<score> findScoreByCourse(String course);
    public score findScoreByStuCourse(score score);
    public int updateScoreByStuCourse(score score);
    public int deleteScoreByStuCourse(score score);
    public int deleteScoreByStu(String student);
    public int deleteScoreByCourse(String course);
    public int insertScoreByStuCourse(score score);
}
