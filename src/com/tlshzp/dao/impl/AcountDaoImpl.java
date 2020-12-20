package com.tlshzp.dao.impl;

import com.tlshzp.dao.AcountDao;
import com.tlshzp.pojo.Acount;
import com.tlshzp.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcountDaoImpl implements AcountDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public Acount findAcountByNumber(long number) {
        String sql = "select * from acount where number = ?";
        Acount acount = template.query(sql, new ResultSetExtractor<Acount>() {
            @Override
            public Acount extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Acount acount1 = null;
                if (resultSet.next()) {
                    acount1 = new Acount();
                    acount1.setNumber(resultSet.getLong("number"));
                    acount1.setPassword(resultSet.getString("password"));
                    acount1.setIdentify(resultSet.getBoolean("identify"));
                }
                return acount1;
            }
        }, number);
        return acount;
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
