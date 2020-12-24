package com.tlshzp.dao;

import com.tlshzp.pojo.Acount;

import java.util.ArrayList;
import java.util.List;

public interface AcountDao {
    //添加用户
    int insertAcount(Acount acount);
    int insertAcount(List<Acount> acounts);
    //查询账号信息
    Acount findAcountByNumber(long number);
    //改
    int updateAcount(Acount acount);
    int deleteAcountByNumber(long number);
}
