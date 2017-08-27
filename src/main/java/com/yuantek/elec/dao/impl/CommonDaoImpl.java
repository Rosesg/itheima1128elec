package com.yuantek.elec.dao.impl;

import javax.annotation.Resource;

import com.yuantek.elec.utils.TUtil;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yuantek.elec.dao.ICommonDao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {
    // 此方法也会是子类来调用 所以也要T型转换
    Class actualType = TUtil.getActualType(this.getClass());

    //spring的注入过程： 找到set方法的形参 进行注入
    @Resource(name="sessionFactory")
    public void setDi(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    public void save(T entity) {
        this.getHibernateTemplate().save(entity);
    }


    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    public T findById(Serializable id) {
        return (T)this.getHibernateTemplate().get(actualType, id);
    }


    public void deleteByIds(Serializable... ids) {
        if(ids != null && ids.length > 0) {
            for(Serializable id : ids) {
                // 先查询
                Object o = this.findById(id);
                // 再删除
                this.getHibernateTemplate().delete(o);
            }
        }
    }

    // hibernate 直接拿ID主键直接删除了！不会去查询了！
    public void deleteByCollection(List<T> list) {
        this.getHibernateTemplate().deleteAll(list);
    }

    /*
            select * from elec_test o where 1=1  #Dao层
            and o.testName like %张%             #service层
            and o.testRemake like %张%           #service层
            order by o.testDate asc,o.testName desc   #service层
     */
    public List<T> findCollectionByConditionNoPage(String condition, Object[] params, Map<String, String> orderBy) {
        // hql：面向对象和属性  sql语句：面向表和字段
        // hql 语句
        String hql = "from "+actualType.getSimpleName()+" o where 1=1 ";
        // 将Map集合中存放的字段排序，组织成order by o.testDate asc,o.testName desc
        String oderByCondition = this.orderByHql(orderBy);
        // 添加条件
        String finalHql = hql + condition + oderByCondition;
        // 执行hql语句进行查询
        /*
               有三种方式进行查询
               1. this.getHibernateTemplate().find
               2. 得到session
               3. 回调
         */
        List<T> list = (List<T>) this.getHibernateTemplate().find(finalHql, params);
        return list;
    }

    // 将Map集合中存放的字段排序，组织成order by o.testDate asc,o.testName desc
    private String orderByHql(Map<String, String> orderBy) {
        StringBuffer sb = new StringBuffer();
        // 任何集合在遍历之前，都要做判断
        if(orderBy != null && orderBy.size() > 0) {
            sb.append(" order by ");
            for(Map.Entry<String,String> entryMap :orderBy.entrySet()) {
                sb.append(entryMap.getKey() + " " + entryMap.getValue() + ",");
            }
            // 在循环之后，删除最后一个逗号 deleteCharAt
            sb.deleteCharAt(sb.length() -1);
        }
        return sb.toString();
    }
}
