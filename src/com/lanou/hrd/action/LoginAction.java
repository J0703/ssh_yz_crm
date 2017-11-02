package com.lanou.hrd.action;

import com.lanou.hrd.domain.Staff;
import com.lanou.hrd.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dllo on 17/10/28.
 */
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {

    private String loginName;
    private String password;

    @Qualifier("staffService")
    @Autowired
    private StaffService staffService;

    // 登录验证
    public String login() {
        this.clearErrorsAndMessages();
        System.out.println(loginName);
        System.out.println(password);

        List<Staff> staffs = staffService.login(loginName);

        if (staffs.size() > 0) {
            Staff staff = staffs.get(0);
            if (!staff.getLoginPwd().equals(password)) {
                this.addFieldError("password_error", "密码错误!");
                return INPUT;
            }

            ServletActionContext.getContext().getApplication().put("staff", staff);
//                ServletActionContext.getRequest().getSession().setAttribute("hrd",hrd);
            return SUCCESS;

        } else {
            this.addFieldError("loginName_error", "用户名不存在!");
            return INPUT;
        }

    }

    // 重新登录
    public String resetLogin() {
        ServletActionContext.getContext().getApplication().remove("hrd");
        return SUCCESS;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
