package com.tlshzp.service.impl;

import com.tlshzp.dao.AcountDao;
import com.tlshzp.dao.impl.AcountDaoImpl;
import com.tlshzp.pojo.Acount;
import com.tlshzp.service.AcountService;

import java.util.ArrayList;
import java.util.List;

public class AcountServiceImpl implements AcountService {
    AcountDao ad = new AcountDaoImpl();

    @Override
    public int insertAcount(Acount acount) {
        return ad.insertAcount(acount);
    }

    @Override
    public int insertAcount(List<Acount> acounts) {
        return ad.insertAcount(acounts);
    }

    @Override
    public Acount findAcountByNumber(long number) {
        return ad.findAcountByNumber(number);
    }

    @Override
    public int updateAcount(Acount acount) {
        return ad.updateAcount(acount);
    }

    @Override
    public int deleteAcountByNumber(long number) {
        return ad.deleteAcountByNumber(number);
    }

}
