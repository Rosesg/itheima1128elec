package com.yuantek.elec.action;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yuantek.elec.utils.TUtil;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,ServletRequestAware,ServletResponseAware {
    
    T entity;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    
    // T型实例化，构造方法实例化成员变量
    public BaseAction() throws IllegalAccessException, InstantiationException {
        Class entityClass = TUtil.getActualType(this.getClass());
        entity = (T) entityClass.newInstance();
    }
    public T getModel() {
        return entity;
    }


    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }


    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }
}
