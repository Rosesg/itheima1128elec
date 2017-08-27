package com.yuantek.elec.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuantek.elec.dao.ICommonDao;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {

    //spring的注入过程： 找到set方法的形参 进行注入
    @Resource(name="sessionFactory")
    public void setDi(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    public void save(T entity) {
        this.getHibernateTemplate().save(entity);
    }
}
