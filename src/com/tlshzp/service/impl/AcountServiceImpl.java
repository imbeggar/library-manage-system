package com.tlshzp.service.impl;

import com.tlshzp.dao.AcountDao;
import com.tlshzp.dao.impl.AcountDaoImpl;
import com.tlshzp.pojo.Acount;
import com.tlshzp.service.AcountService;

import java.util.ArrayList;

public class AcountServiceImpl implements AcountService {
    AcountDao ad = new AcountDaoImpl();

    @Override
    public Acount findAcountByNumber(long number) {
        return ad.findAcountByNumber(number);
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
