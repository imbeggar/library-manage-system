package com.tlshzp.dao;

import com.tlshzp.pojo.Acount;

import java.util.ArrayList;

public interface AcountDao {
    //添加用户
    int insertVerify(long number, String password, boolean identify);
    int insertVerify(ArrayList<Long> numbers, ArrayList<String> passwords, ArrayList<Boolean> identifys);
    //查询账号信息
    Acount findAcountByNumber(long number);
    //改
    int updateAcount(Acount acount);
}
