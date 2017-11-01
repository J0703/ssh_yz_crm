package com.lanou.teach.service;


import com.lanou.teach.domain.Classes;
import com.lanou.teach.domain.PageBean;


/**
 * Created by dllo on 17/10/31.
 */
public interface ClassesService {

    PageBean<Classes> findPagingAll(int pc, int ps);

    Classes findById(String classId);

    void saveOrUpdate(Classes classes);
}
