package com.ray.dao;

import com.ray.pojo.teacher;
import com.ray.pojo.course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
// 如果在SpringbootApplicaton中使用了MapperScan则可以单独为每一个mapper使用@Mapper注解

@Mapper
public interface courseDao {
    public List<course> findAllCourse();
    public course findCourseById(String id);
    public int updateCourseById(course course);
    public int deleteCourseById(String id);
    public int insertCourse(course course);
    public List<course> findCourseByTech(String teacher);
}
