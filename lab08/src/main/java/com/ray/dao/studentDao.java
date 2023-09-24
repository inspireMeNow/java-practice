package com.ray.dao;

import com.ray.pojo.score;
import com.ray.pojo.student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// 如果在SpringbootApplicaton中使用了MapperScan则可以单独为每一个mapper使用@Mapper注解
@Mapper
public interface studentDao {
    public List<student> findAllStu();

    public student findStuById(String id);

    public List<student> findStuByEnroll(String enroll);

    public List<student> findStuByMajor(String major);

    public int updateStuById(student student);

    public int deleteStuById(String id);

    public int insertStu(student student);

    public List<score> findCourseByStu(String id);
}
