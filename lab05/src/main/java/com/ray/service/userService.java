package com.ray.service;

import com.ray.pojo.user;

import java.util.List;

public interface userService {
    public List<user> findAllUser();

    public user findUserById(String id);

    public int login(user user);

    public int updateUserById(user user);

    public int deleteUserById(String id);

    public int insertUser(user user);
    public user getByToken(String token);
}
