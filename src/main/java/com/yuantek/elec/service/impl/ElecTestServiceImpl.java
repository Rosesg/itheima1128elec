package com.yuantek.elec.service.impl;

import com.yuantek.elec.dao.IElecTestDao;
import com.yuantek.elec.domain.ElecTest;
import com.yuantek.elec.service.IElecTestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 11602 on 2017/8/27.
 */
@Service(IElecTestService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecTestServiceImpl implements IElecTestService{

    @Resource(name=IElecTestDao.SERVICE_NAME)
    IElecTestDao elecTestDao;
    //保存测试表
    @Override
    @Transactional(readOnly = false,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public void saveElecTest(ElecTest elecTest) {
        elecTestDao.save(elecTest);
    }
}
