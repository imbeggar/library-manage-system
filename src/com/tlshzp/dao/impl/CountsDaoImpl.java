package com.tlshzp.dao.impl;

import com.tlshzp.dao.CountsDao;
import com.tlshzp.pojo.Count;
import com.tlshzp.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CountsDaoImpl implements CountsDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Count> getCount() {
        String sql = "select * from counts";
        List<Count> counts = template.query(sql, new BeanPropertyRowMapper<Count>(Count.class));
        return counts;
    }

    @Override
    public int addCount(int val) {
        String sql = "update counts set cnt = ? where tmp = 1";
        int res = template.update(sql, new Object[]{val});
        return res;
    }
}
