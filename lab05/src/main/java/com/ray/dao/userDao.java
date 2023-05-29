package com.ray.dao;

import com.ray.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface userDao {
    public List<user> findAllUser();

    public user findUserById(String id);

    public int login(user user);

    public int updateUserById(user user);

    public int deleteUserById(String id);

    public int insertUser(user user);
    public user getByToken(String token);
}
