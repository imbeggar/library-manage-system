package com.tlshzp.dao;

import com.tlshzp.pojo.Book;
import com.tlshzp.pojo.User;

import java.util.Date;
import java.util.List;

public interface UserDao {
    //增
    int insertUser(User user);
    int insertUser(List<User> users);
    //删
    int deleteUserByNumber(String number);
    //改
    int updateUser(User user);
    //查
    List<User> selectAllUsers();
    List<User> findUserById(String id);
    List<User> findUserByName(String name);
    List<User> findUserBySex(boolean sex);
    List<User> findUserByPhone(String phone);
    List<User> findUserByEmail(String email);
}
