package com.lanou.staff.dao.impl;


import com.lanou.staff.dao.BaseDao;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    private Class<T> beanClass;

    public BaseDaoImpl() {

        // this ,在运行时表示的【当前运行类】。在编译时表示就是【当前类】
        // 1 获得当前运行类的父类，父类具有泛型信息，
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 2 获得实际参数
        beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public T findById(Serializable id) {
        T t = getHibernateTemplate().get(beanClass,id);
        return t;
    }

    @Override
    public List<T> findAll(String hql) {
        List<T> tList = (List<T>) getHibernateTemplate().find(hql);
        return tList;
    }

    @Override
    public List<T> find(String hql, Object[] params) {
        List<T> tList = (List<T>) getHibernateTemplate().find(hql,params);
        return tList;
    }

    @Override
    public void saveOrUpdate(T t) {
        getHibernateTemplate().saveOrUpdate(t);
    }


}
