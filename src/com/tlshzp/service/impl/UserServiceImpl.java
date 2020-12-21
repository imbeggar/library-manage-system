package com.tlshzp.service.impl;

import com.tlshzp.dao.UserDao;
import com.tlshzp.dao.impl.UserDaoImpl;
import com.tlshzp.pojo.User;
import com.tlshzp.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();
    @Override
    public int insertUser(User user) {
        return ud.insertUser(user);
    }

    @Override
    public int insertUser(List<User> users) {
        return ud.insertUser(users);
    }

    @Override
    public int deleteUserByNumber(long number) {
        return ud.deleteUserByNumber(number);
    }

    @Override
    public int updateUser(User user) {
        return ud.updateUser(user);
    }

    @Override
    public List<User> selectAllUsers() {
        return ud.selectAllUsers();
    }

    @Override
    public User findUserByNumber(long number) {
        return ud.findUserByNumber(number);
    }

    @Override
    public List<User> findUserByName(String name) {
        return ud.findUserByName(name);
    }

    @Override
    public List<User> findUserBySex(boolean sex) {
        return ud.findUserBySex(sex);
    }

    @Override
    public List<User> findUserByPhone(long phone) {
        return ud.findUserByPhone(phone);
    }

    @Override
    public List<User> findUserByEmail(String email) {
        return ud.findUserByEmail(email);
    }
}
