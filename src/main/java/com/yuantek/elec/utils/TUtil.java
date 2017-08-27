package com.yuantek.elec.utils;

import com.yuantek.elec.action.BaseAction;

import java.lang.reflect.ParameterizedType;

/**
 * Created by 11602 on 2017/8/27.
 */
public class TUtil {

    public static Class getActualType(Class aClass) {
        // T型转换 父子关系 子类会传真实类 子类实例化会调用父类的构造 型 所有可以确定T的类型
        // T型转换的意思就是确定T的类型
        ParameterizedType parameterizedType = (ParameterizedType) aClass.getGenericSuperclass();
        Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
        return entityClass;
    }
}
