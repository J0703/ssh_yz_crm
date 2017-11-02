package com.lanou.base_util.impl;


import com.lanou.base_util.BaseDao;
import com.lanou.base_util.PageBean;
import org.hibernate.Query;
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
    public List<T> findAll() {
        List<T> tList = (List<T>) getHibernateTemplate().find("from "+beanClass.getName());
        return tList;
    }

    @Override
    public List<T> find(String hql, Object... params) {
        List<T> tList = (List<T>) getHibernateTemplate().find("from " + beanClass.getName() + " where 1=1" + hql, params);
        return tList;
    }

    @Override
    public T findSingle(String hql, Object... params) {
        T t = (T) this.getHibernateTemplate().find("from " + beanClass.getName() + " where 1=1" + hql, params);
        return t;
    }

    @Override
    public PageBean<T> findPagingAll(int pc,int ps) {
        PageBean<T> pb = new PageBean<T>();
        pb.setPc(pc);
        pb.setPs(ps);
        String hql = "select count(*) from "+beanClass.getName()+" where 1=1";
        Number count = (Number) getHibernateTemplate().find(hql).listIterator().next();
        int tr = count.intValue();
        System.out.println(tr);
        pb.setTr(tr);
        String hql1 = "from "+beanClass.getName();
        Query query = currentSession().createQuery(hql1);

        query.setFirstResult((pc-1)*ps);
        query.setMaxResults(ps);
        List<T> tList = query.list();
        pb.setBeanList(tList);
        return pb;
    }

    @Override
    public void saveOrUpdate(T t) {
        getHibernateTemplate().saveOrUpdate(t);
    }

}
