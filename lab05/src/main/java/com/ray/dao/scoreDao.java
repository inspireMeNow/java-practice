package com.ray.dao;

import com.ray.pojo.course;
import com.ray.pojo.score;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
// 如果在SpringbootApplicaton中使用了MapperScan则可以单独为每一个mapper使用@Mapper注解

@Mapper
public interface scoreDao {
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
