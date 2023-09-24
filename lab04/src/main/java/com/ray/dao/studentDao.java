package com.ray.dao;
import com.ray.pojo.student;

import java.util.List;
public interface studentDao {
    public abstract List<student> findAllStu();
    public abstract student findStuById(String id);
    public abstract List<student> findStuByEnroll(String enroll);
    public abstract List<student> findStuByMajor(String major);
    public abstract int updateStuById(student student);
    public abstract int deleteStuById(String id);
    public abstract int insertStu(student student);

}
