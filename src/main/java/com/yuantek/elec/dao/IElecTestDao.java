package com.yuantek.elec.dao;

import com.yuantek.elec.domain.ElecTest;

public interface IElecTestDao extends ICommonDao<ElecTest> {
    // 就不用在此类中定义重复的方法了！
    public static final String SERVICE_NAME = "com.yuantek.elec.dao.impl.ElecTestDaoImpl";
    
}
