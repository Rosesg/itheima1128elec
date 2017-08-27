package com.yuantek.elec.dao.impl;

import org.springframework.stereotype.Repository;

import com.yuantek.elec.dao.IElecTestDao;
import com.yuantek.elec.domain.ElecTest;
/**
 * 
 *      @Repository 相当于在spring容器中定义：
 *      <bean id="com.yuantek.elec.dao.impl.ElecTestDaoImpl" class="com.yuantek.elec.dao.impl.ElecTestDaoImpl" />
 *
 */
@Repository(IElecTestDao.SERVICE_NAME)
public class ElecTestDaoImpl extends CommonDaoImpl<ElecTest> implements IElecTestDao {
    
}
