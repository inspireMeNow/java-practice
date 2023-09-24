package com.ray.service;

import com.ray.pojo.teacher;

import java.util.List;

public interface teacherService {
    public abstract List<teacher> findAllTech();
    public abstract teacher findTechById(String id);
    public abstract int updateTechById(teacher teacher);
    public abstract int deleteTechById(String id);
    public abstract int insertTech(teacher teacher);
}
