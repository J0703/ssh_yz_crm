package com.lanou.hrd.action;

import com.lanou.hrd.domain.Department;
import com.lanou.hrd.domain.Post;
import com.lanou.hrd.domain.Staff;
import com.lanou.hrd.service.DepartmentService;
import com.lanou.hrd.service.PostService;
import com.lanou.hrd.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport implements ModelDriven<Staff> {
    private Staff staff;

    private String depId;
    private Set<Post> postList;

    // 修改密码
    private String oldPassword;// 旧密码
    private String newPassword;// 新密码
    private String reNewPassword;// 确认新密码

    @Qualifier("postService")
    @Autowired
    private PostService postService;

    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;

    @Qualifier("staffService")
    @Autowired
    private StaffService staffService;
    // 联动-部门
    public String departFindAll() {
        List<Department> departments = departmentService.findAll();
        List<Staff> staffs = staffService.findAll();
        ServletActionContext.getRequest().setAttribute("staffs", staffs);
        ServletActionContext.getRequest().getSession().setAttribute("departments", departments);
        return SUCCESS;
    }
    // 联动-职务
    public String findPost() {
        Department depart = departmentService.findById(depId);
        postList = depart.getPosts();
        return SUCCESS;
    }

//    public String find() {
//        List<Staff> staffs = staffService.find(hrd);
//        ServletActionContext.getRequest().setAttribute("staffs", staffs);
//
//        return SUCCESS;
//    }
    // 条件查询员工
    public String findStaff() {
        List<Staff> staffs = staffService.find(staff);
        ServletActionContext.getRequest().setAttribute("staffs", staffs);
        return SUCCESS;
    }
    // 回显
    public String findById() {
        String staffId = staff.getStaffId();
        Staff sta = staffService.findById(staffId);
        ServletActionContext.getRequest().setAttribute("staff", sta);
        return SUCCESS;
    }
    // 跳转添加页面
    public String addStaff(){
        return SUCCESS;
    }
    // 保存 或 更新
    public String saveOrUpdate() {
        String staffId = staff.getStaffId();
        staffService.saveOrUpdate(staff);
        return SUCCESS;
    }
    // 重置密码
    public String modPwd() {
        Staff sta = (Staff) ServletActionContext.getContext().getApplication().get("staff");

        if (!oldPassword.equals(sta.getLoginPwd())) {
            addFieldError("oldPassword_error", "原密码错误!");
            return ERROR;
        } else if (!newPassword.equals(reNewPassword)) {
            addFieldError("reNewPassword_error", "确认密码输入错误!");
            return ERROR;
        }

        sta.setLoginPwd(newPassword);
        staffService.saveOrUpdate(sta);
        return SUCCESS;
    }

    @Override
    public Staff getModel() {
        staff = new Staff();
        return staff;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public Set<Post> getPostList() {
        return postList;
    }

    public void setPostList(Set<Post> postList) {
        this.postList = postList;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public StaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }
}
