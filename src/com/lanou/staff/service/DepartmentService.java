package com.lanou.staff.service;


import com.lanou.staff.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public interface DepartmentService {

    List<Department> findAll();

    Department findById(String depID);

    void save(Department department);

    void saveOrUpdate(Department department);

}
