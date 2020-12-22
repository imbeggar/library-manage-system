package com.tlshzp.dao.impl;

import com.tlshzp.dao.UserDao;
import com.tlshzp.pojo.User;
import com.tlshzp.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int insertUser(User user) {
        String sql = "insert into user (number, name, sex, phone, email) values (?, ?, ?, ?, ?)";
        int count = template.update(sql, new Object[]{
                user.getNumber(),
                user.getName(),
                user.isSex(),
                user.getPhone(),
                user.getEmail()
        });
        return count;
    }

    @Override
    public int insertUser(List<User> users) {
        String sql = "insert into user (number, name, sex, phone, email) values (?, ?, ?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        for (User user : users) {
            batchArgs.add(new Object[]{
                    user.getNumber(),
                    user.getName(),
                    user.isSex(),
                    user.getPhone(),
                    user.getEmail()
            });
        }
        int[] counts = template.batchUpdate(sql, batchArgs);
        int count = 0;
        for (int i : counts)
            count += i;
        return count;
    }

    @Override
    public int deleteUserByNumber(long number) {
        String sql = "delete from user where number = ?";
        int count = template.update(sql, number);
        return count;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set name = ?, sex = ?, phone = ?, email = ? where number = ?";
        int count = template.update(sql, new Object[]{
                user.getName(),
                user.isSex(),
                user.getPhone(),
                user.getEmail(),
                user.getNumber()
        });
        return count;
    }

    @Override
    public List<User> selectAllUsers() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByNumber(long number) {
        String sql = "select * from user where number = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), number);
        return user;
    }

    @Override
    public List<User> findUserByName(String name) {
        String sql = "select * from user where name = ?";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), name);
        return users;
    }

    @Override
    public List<User> findUserBySex(boolean sex) {
        String sql = "select * from user where sex = ?";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), sex);
        return users;
    }

    @Override
    public List<User> findUserByPhone(long phone) {
        String sql = "select * from user where phone = ?";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), phone);
        return users;
    }

    @Override
    public List<User> findUserByEmail(String email) {
        String sql = "select * from user where email = ?";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), email);
        return users;
    }
}
