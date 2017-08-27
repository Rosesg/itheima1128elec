package com.yuantek.elec.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 11602 on 2017/8/26.
 */
public interface ICommonDao<T> {

    void save(T entity);
    void update(T entity);
    // 使用主键ID查询对象
    T findById(Serializable id);
    // 使用主键ID删除
    void deleteByIds(Serializable... ids);
    // 使用集合删除
    void deleteByCollection(List<T> list);

    /**
     * 单表条件查询
     * @param condition 查询条件
     * @param params  查询条件对应的值
     * @param orderBy 排序条件 LinkedHashMap
     * @return
     */
    List<T> findCollectionByConditionNoPage(String condition,Object[] params,Map<String,String> orderBy);
}
