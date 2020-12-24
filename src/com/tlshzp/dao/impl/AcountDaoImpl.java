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
import java.util.List;

public class AcountDaoImpl implements AcountDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public int insertAcount(Acount acount) {
        String sql = "insert into acount(number, password, identify) values (?, ?, ?)";
        int count = template.update(sql, new Object[]{acount.getNumber(), acount.getPassword(), acount.isIdentify()});
        return count;
    }

    @Override
    public int insertAcount(List<Acount> acounts) {
        String sql = "insert into acount(number, password, identify) values (?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<>();
        for (Acount acount : acounts) {
            batchArgs.add(new Object[]{
                acount.getNumber(),
                acount.getPassword(),
                acount.isIdentify()
            });
        }
        int[] counts = template.batchUpdate(sql, batchArgs);
        int count = 0;
        for (int i : counts)
            count += i;
        return count;
    }

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
    public int updateAcount(Acount acount) {
        String sql = "update acount set password = ?, identify = ? where number = ?";
        int count = template.update(sql, new Object[]{acount.getPassword(), acount.isIdentify(), acount.getNumber()});
        return count;
    }

    @Override
    public int deleteAcountByNumber(long number) {
        String sql = "delete from acount where number = ?";
        int count = template.update(sql, new Object[]{number});
        return count;
    }
}
