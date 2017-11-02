package com.lanou.hrd.action;

import com.lanou.hrd.domain.Department;
import com.lanou.base_util.PageBean;
import com.lanou.hrd.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by dllo on 17/10/26.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
    private Department department;

    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;

    private String pc;
    // 分页查询所有部门
    public String findAll() {
        int pc = getPc();
        int ps = 3;

        PageBean<Department> pb = departmentService.findPagingAll(pc, ps);

        ServletActionContext.getRequest().setAttribute("pb", pb);
        return SUCCESS;

    }

    // 添加部门
    public String addDepart(){
        return SUCCESS;
    }

    // 通过 Id 查询部门,用于部门修改页面的回显
    public String findById() {
        String depID = department.getDepID();
        Department department = departmentService.findById(depID);
        // 将查询到的部门对象存入 request 域中
        ServletActionContext.getRequest().setAttribute("department", department);
        return SUCCESS;
    }

    /**
     * 调用saveOrUpdate方法之前要进行判空操作,
     * saveOrUpdate 识别 id 是否为 null;
     * 如果为""字符串,要将其值改为 null,否则会将""字符串作为主键存入数据库表中
     */
    public String saveOrUpdate() {
        String depID = department.getDepID();
        // 判空
        if (depID.equals("")) {
            department.setDepID(null);
        }
        // 执行 saveOrUpdate 方法
        departmentService.saveOrUpdate(department);
        return SUCCESS;
    }

    @Override
    public Department getModel() {
        department = new Department();
        return department;
    }

    public int getPc() {

        String value = pc;
        System.out.println("pc:" + pc);
        if (value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
    }

    public void setPc(String pc) {
        this.pc = pc;
    }
}
