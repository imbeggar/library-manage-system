package com.tlshzp.service.impl;

import com.tlshzp.dao.CountsDao;
import com.tlshzp.dao.impl.CountsDaoImpl;
import com.tlshzp.pojo.Count;
import com.tlshzp.service.CountsServise;

import java.util.List;

public class CountsServiseImpl implements CountsServise {
    CountsDao cd = new CountsDaoImpl();
    @Override
    public int getCount() {
        List<Count> counts = cd.getCount();
        int count = 0;
        for (Count count1 : counts) {
            count = count1.getCnt();
        }
        return count;
    }

    @Override
    public int addCount(int val) {
        return cd.addCount(val);
    }
}
