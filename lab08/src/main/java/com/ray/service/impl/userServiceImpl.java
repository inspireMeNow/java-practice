package com.ray.service.impl;

import com.ray.dao.teacherDao;
import com.ray.pojo.user;
import com.ray.dao.userDao;
import com.ray.service.userService;
import com.ray.dao.studentDao;
import com.ray.service.impl.passwordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {
    @Autowired
    userDao userDao;
    @Autowired
    passwordServiceImpl passwordService;
    @Autowired
    teacherDao teacherDao;
    @Autowired
    studentDao studentDao;

    @Override
    public List<user> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public user findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public int login(user user) {
        if (userDao.findUserById(user.getId()) == null) {
            return -1;
        }
        if(userDao.findUserById(user.getId()).getIdtype()!=user.getIdtype()){
            return -1;
        }
        if (passwordService.validatePassword("123456", passwordService.encryptPassword(user.getPassword()))) {
            return 1;
        }
        return -1;
    }

    @Override
    public int updateUserById(user user) {
        if (userDao.findUserById(user.getId()) == null) {
            return -1;
        }
        user.setPassword(passwordService.encryptPassword(user.getPassword()));
        return userDao.updateUserById(user);
    }

    @Override
    public int deleteUserById(String id) {
        if (userDao.findUserById(id) == null) {
            return -1;
        }
        return userDao.deleteUserById(id);
    }

    @Override
    public int insertUser(user user) {
        if (user.getIdtype() == 1) {
            if (teacherDao.findTechById(user.getId()) != null) {
                user.setPassword(passwordService.encryptPassword(user.getPassword()));
                return userDao.insertUser(user);
            }
        }
        if (user.getIdtype() == 0) {
            if (studentDao.findStuById(user.getId()) != null) {
                user.setPassword(passwordService.encryptPassword(user.getPassword()));
                return userDao.insertUser(user);
            }
        }
        return -1;
//        user.setPassword(passwordService.encryptPassword(user.getPassword()));
//        return userDao.insertUser(user);
    }
    @Override
    public user getByToken(String token){
        return userDao.getByToken(token);
    }
}
