package com.lanou.trd.service.impl;

import com.lanou.base_util.PageBean;
import com.lanou.trd.dao.ClassesDao;
import com.lanou.trd.domain.Classes;
import com.lanou.trd.service.ClassesService;


/**
 * Created by dllo on 17/10/31.
 */
public class ClassesServiceImpl implements ClassesService{

    private ClassesDao classesDao;
    @Override
    public PageBean<Classes> findPagingAll(int pc, int ps) {
        return classesDao.findPagingAll(pc, ps);
    }

    @Override
    public Classes findById(String classId) {
        return classesDao.findById(classId);
    }

    @Override
    public void saveOrUpdate(Classes classes) {
        classesDao.saveOrUpdate(classes);
    }

    public ClassesDao getClassesDao() {
        return classesDao;
    }

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }


}
