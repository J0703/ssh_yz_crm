package com.lanou.base_util.interceptor;

import com.lanou.hrd.domain.Staff;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/11/1.
 */
public class PostActionInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        Staff staff = (Staff) ServletActionContext.getContext().getApplication().get("staff");
        if (!staff.getPost().getPostId().equals("2c9090da5f76a5d5015f7762f4670001")){
            return "pass";
        }

        return actionInvocation.invoke();
    }
}
