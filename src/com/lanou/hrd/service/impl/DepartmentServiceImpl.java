package com.lanou.hrd.service.impl;

import com.lanou.hrd.dao.DepartmentDao;
import com.lanou.hrd.domain.Department;
import com.lanou.base_util.PageBean;
import com.lanou.hrd.service.DepartmentService;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public PageBean<Department> findPagingAll(int pc,int ps) {
        return departmentDao.findPagingAll(pc, ps);
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
