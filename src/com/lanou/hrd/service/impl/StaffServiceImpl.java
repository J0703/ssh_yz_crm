package com.lanou.hrd.service.impl;

import com.lanou.hrd.dao.StaffDao;
import com.lanou.hrd.domain.Staff;
import com.lanou.hrd.service.StaffService;

import java.util.ArrayList;
import java.util.List;

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
        if (staff.getStaffName() != null && !staff.getStaffName().trim().isEmpty() && !staff.getStaffName().equals("请输入关键字")){
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
        System.out.println("hrd:"+staffs);
        return staffs;
    }
    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
