package com.tlshzp.service;

import com.tlshzp.pojo.User;

import java.util.List;

public interface UserService {
    //增
    int insertUser(User user);
    int insertUser(List<User> users);
    //删
    int deleteUserByNumber(long number);
    //改
    int updateUser(User user);
    //查
    List<User> selectAllUsers();
    User findUserByNumber(long number);
    List<User> findUserByName(String name);
    List<User> findUserBySex(boolean sex);
    List<User> findUserByPhone(long phone);
    List<User> findUserByEmail(String email);
}
