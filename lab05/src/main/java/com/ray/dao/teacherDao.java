package com.ray.dao;

import com.ray.pojo.course;
import com.ray.pojo.teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// 如果在SpringbootApplicaton中使用了MapperScan则可以单独为每一个mapper使用@Mapper注解
@Mapper
public interface teacherDao {
    public List<teacher> findAllTech();

    public teacher findTechById(String id);

    public int updateTechById(teacher teacher);

    public int deleteTechById(String id);

    public int insertTech(teacher teacher);

    public List<course> findCourseById(String id);

}
