package com.tlshzp.dao;

import com.tlshzp.pojo.Acount;

import java.util.ArrayList;

public interface AcountDao {
    //查询账号信息
    Acount findAcountByNumber(long number);
    //添加用户
    int insertVerify(long number, String password, boolean identify);
    int insertVerify(ArrayList<Long> numbers, ArrayList<String> passwords, ArrayList<Boolean> identifys);
}
