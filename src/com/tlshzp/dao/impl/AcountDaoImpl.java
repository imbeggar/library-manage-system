package com.tlshzp.dao.impl;

import com.tlshzp.dao.AcountDao;
import com.tlshzp.pojo.Acount;
import com.tlshzp.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class AcountDaoImpl implements AcountDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public Acount findAcountByNumber(long number) {
        String sql = "select * from acount where number = ?";
        Acount acount = template.queryForObject(sql, new BeanPropertyRowMapper<>(Acount.class), number);
        return acount;
    }

    @Override
    public int updateAcount(Acount acount) {
        String sql = "update acount set password = ?, identify = ? where number = ?";
        int count = template.update(sql, new Object[]{acount.getPassword(), acount.isIdentify(), acount.getNumber()});
        return count;
    }

    @Override
    public int insertVerify(long number, String password, boolean identify) {
        return 0;
    }

    @Override
    public int insertVerify(ArrayList<Long> numbers, ArrayList<String> passwords, ArrayList<Boolean> identifys) {
        return 0;
    }
}
