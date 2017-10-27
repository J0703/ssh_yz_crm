package com.lanou.staff.action;

import com.lanou.staff.domain.Department;
import com.lanou.staff.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dllo on 17/10/26.
 */
@Controller("departmentAction")
@Scope
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
    private Department department;

//    String depID = department.getDepID();

    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;
    public String findAll(){
        List<Department> departments = departmentService.findAll();
        if (departments.size() > 0){
            ServletActionContext.getRequest().setAttribute("departments",departments);
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    public String findById(){
        System.out.println(department.getDepID());
        System.out.println(department);
        String depID = department.getDepID();
        Department department = departmentService.findById(depID);
        ServletActionContext.getRequest().setAttribute("department",department);
        return SUCCESS;
    }

    public String saveOrUpdate(){
        String depID = department.getDepID();
        if (depID.equals("")){
            department.setDepID(null);
        }
        System.out.println("depID:"+depID);
        departmentService.saveOrUpdate(department);
        return SUCCESS;
    }

    @Override
    public Department getModel() {
        department = new Department();
        return department;
    }



}
