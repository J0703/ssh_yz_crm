package com.lanou.staff.service.impl;

import com.lanou.staff.dao.DepartmentDao;
import com.lanou.staff.domain.Department;
import com.lanou.staff.service.DepartmentService;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAll() {
        String hql = "from Department";
        return departmentDao.findAll(hql);
    }

    @Override
    public Department findById(String depID) {
        Department department = departmentDao.findById(depID);
        return department;
    }

    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }


    @Override
    public void saveOrUpdate(Department department) {
        departmentDao.saveOrUpdate(department);
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
}
