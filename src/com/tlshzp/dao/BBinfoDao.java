package com.tlshzp.dao;

import com.tlshzp.pojo.BBInfo;

import java.util.List;

public interface BBinfoDao {
    List<BBInfo> getInfoByNumber(long number);
    BBInfo getInfoById(int id);
    List<BBInfo> getAllBBInfo();
    int insertInfo(BBInfo bbInfo);
    int deleteInfoById(int id);
}
