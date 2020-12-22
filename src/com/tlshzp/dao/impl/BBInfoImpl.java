package com.tlshzp.dao.impl;

import com.tlshzp.dao.BBinfoDao;
import com.tlshzp.pojo.BBInfo;
import com.tlshzp.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BBInfoImpl implements BBinfoDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<BBInfo> getInfoByNumber(long number) {
        String sql = "select * from bb_info where number = ?";
        List<BBInfo> bbInfos = template.query(sql, new BeanPropertyRowMapper<BBInfo>(BBInfo.class), number);
        return bbInfos;
    }

    @Override
    public BBInfo getInfoById(int id) {
        String sql = "select * from bb_info where id = ?";
        BBInfo bbInfo = template.query(sql, new ResultSetExtractor<BBInfo>() {
            @Override
            public BBInfo extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                BBInfo bbInfo1 = null;
                if (resultSet.next()) {
                    bbInfo1.setNumber(resultSet.getLong("number"));
                    bbInfo1.setId(resultSet.getInt("id"));
                    bbInfo1.setBorrow_date(resultSet.getDate("borrow_date"));
                    bbInfo1.setBack_date(resultSet.getDate("back_date"));
                }
                return bbInfo1;
            }
        }, id);
        return bbInfo;
    }

    @Override
    public List<BBInfo> getAllBBInfo() {
        String sql = "select * from bb_info";
        List<BBInfo> bbInfos = template.query(sql, new BeanPropertyRowMapper<BBInfo>(BBInfo.class));
        return bbInfos;
    }

    @Override
    public int insertInfo(BBInfo bbInfo) {
        String sql = "insert into bb_info (number, id, borrow_date, back_date) values (?, ?, ?, ?)";
        int count = template.update(sql, new Object[]{
                bbInfo.getNumber(),
                bbInfo.getId(),
                bbInfo.getBack_date(),
                bbInfo.getBack_date()
        });
        return count;
    }
}
