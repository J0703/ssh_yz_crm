package com.lanou.hrd.service;


import com.lanou.hrd.domain.Department;
import com.lanou.base_util.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public interface DepartmentService {

    List<Department> findAll();

    PageBean<Department> findPagingAll(int pc, int ps);

    Department findById(String depID);

    void save(Department department);

    void saveOrUpdate(Department department);

}
