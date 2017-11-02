package com.lanou.base_util.interceptor;

import com.lanou.hrd.domain.Staff;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/10/30.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        Staff staff = (Staff) ServletActionContext.getContext().getApplication().get("staff");
        System.out.println(staff);
        if (staff==null){
            ServletActionContext.getRequest().setAttribute("msg","您未登录,请先登录!");
            return Action.LOGIN;
        }

        return actionInvocation.invoke();
    }
}
