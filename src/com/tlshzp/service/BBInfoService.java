package com.tlshzp.service;

import com.tlshzp.pojo.BBInfo;

import java.util.List;

public interface BBInfoService {
    List<BBInfo> findInfoByNumber(long number);
    BBInfo findInfoById(int id);
    List<BBInfo> getAllBBInfo();
    int insertInfo(BBInfo bbInfo);
    int deleteInfoById(int id);
}
