package com.tlshzp.dao;

import com.tlshzp.pojo.Count;

import java.util.List;

public interface CountsDao {
    List<Count> getCount();
    int addCount(int val);
}
