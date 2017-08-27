package com.yuantek.elec.service;

import com.yuantek.elec.domain.ElecTest;

/**
 * Created by 11602 on 2017/8/27.
 */
public interface IElecTestService {

    String SERVICE_NAME = "com.yuantek.elec.service.impl.ElecTestServiceImpl";

    void saveElecTest(ElecTest elecTest);
}
