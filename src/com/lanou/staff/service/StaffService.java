package com.lanou.staff.service;

import com.lanou.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffService {

    List<Staff> findAll();

    List<Staff> find(Staff staff);

    Staff findById(String staffId);

    void saveOrUpdate(Staff staff);

    List<Staff> login(String username);

}
