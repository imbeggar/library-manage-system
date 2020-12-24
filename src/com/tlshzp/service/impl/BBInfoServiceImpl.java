package com.tlshzp.service.impl;

import com.tlshzp.dao.BBinfoDao;
import com.tlshzp.dao.impl.BBInfoImpl;
import com.tlshzp.pojo.BBInfo;
import com.tlshzp.service.BBInfoService;

import java.util.List;

public class BBInfoServiceImpl implements BBInfoService {
    BBinfoDao bBinfoDao = new BBInfoImpl();
    @Override
    public List<BBInfo> findInfoByNumber(long number) {
        return bBinfoDao.getInfoByNumber(number);
    }

    @Override
    public BBInfo findInfoById(int id) {
        return bBinfoDao.getInfoById(id);
    }

    @Override
    public List<BBInfo> getAllBBInfo() {
        return bBinfoDao.getAllBBInfo();
    }

    @Override
    public int insertInfo(BBInfo bbInfo) {
        return bBinfoDao.insertInfo(bbInfo);
    }

    @Override
    public int deleteInfoById(int id) {
        return bBinfoDao.deleteInfoById(id);
    }
}
