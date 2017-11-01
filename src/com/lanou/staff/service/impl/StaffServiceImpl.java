package com.lanou.staff.service.impl;

import com.lanou.staff.dao.StaffDao;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.StaffService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffServiceImpl implements StaffService{
    private StaffDao staffDao;

    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public List<Staff> find(Staff staff) {
        StringBuilder builder = new StringBuilder();
        List<Object> list = new ArrayList<>();
        String departId = staff.getPost().getDepartment().getDepID();
        if (departId != null && !departId.trim().isEmpty() && !departId.equals("-1")){
            builder.append(" and post.department.depID=?");
            list.add(departId);
        }
        String postId = staff.getPost().getPostId();
        if (postId != null && !postId.trim().isEmpty() && !postId.equals("-1")){
            builder.append(" and post.postId=?");
            list.add(postId);
        }
        if (staff.getStaffName() != null && !staff.getStaffName().trim().isEmpty()){
            builder.append(" and staffName like ?");
            list.add("%"+staff.getStaffName()+"%");
        }
        String hql = String.valueOf(builder);
        Object[] params = list.toArray();
        List<Staff> staffs = staffDao.find(hql, params);
        System.out.println(staffs);
        return staffs;
    }

    @Override
    public Staff findById(String staffId) {
        return staffDao.findById(staffId);
    }

    @Override
    public void saveOrUpdate(Staff staff) {
        staffDao.saveOrUpdate(staff);
    }

    @Override
    public List<Staff> login(String username) {

        String hql = " and loginName=?";
        Object[] params = {username};
        List<Staff> staffs = staffDao.find(hql, params);
        System.out.println("staff:"+staffs);
        return staffs;
    }
    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
