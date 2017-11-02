package com.lanou.trd.service;


import com.lanou.base_util.PageBean;
import com.lanou.trd.domain.Classes;


/**
 * Created by dllo on 17/10/31.
 */
public interface ClassesService {

    PageBean<Classes> findPagingAll(int pc, int ps);

    Classes findById(String classId);

    void saveOrUpdate(Classes classes);
}
