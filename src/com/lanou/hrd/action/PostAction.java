package com.lanou.hrd.action;

import com.lanou.hrd.domain.Department;
import com.lanou.base_util.PageBean;
import com.lanou.hrd.domain.Post;
import com.lanou.hrd.service.DepartmentService;
import com.lanou.hrd.service.PostService;
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
@Controller("postAction")
@Scope("prototype")
public class PostAction extends ActionSupport implements ModelDriven<Post>{
    private Post post;
    private String dname;

    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;
    @Qualifier("postService")
    @Autowired
    private PostService postService;

    private String pc;
    // 分页查询所有职务
    public String findAll(){
        int pc = getPc();
        int ps = 3;
        PageBean<Post> pb = postService.findAll(pc,ps);
        ServletActionContext.getRequest().setAttribute("pb",pb);
        return SUCCESS;
    }

    public int getPc(){
        String value = pc;
        System.out.println("pc:"+pc);
        if (value == null || value.trim().isEmpty()){
            return 1;
        }
        return Integer.parseInt(value);
    }
    // 编辑 回显单个职务信息
    public String findById(){
        // 根据 Id 查询出单个 Post 对象
        String postId = post.getPostId();
        Post po = postService.findById(postId);
        // 下拉列表的部门集合
        List<Department> departments = departmentService.findAll();

        ServletActionContext.getRequest().getSession().setAttribute("post",po);
        ServletActionContext.getRequest().setAttribute("departments",departments);
        return SUCCESS;
    }
    // 添加 部门下拉列表
    public String showDepartments(){
        List<Department> departments = departmentService.findAll();
        ServletActionContext.getRequest().setAttribute("departments",departments);
        return SUCCESS;
    }
    // saveOrUpdate 方法
    public String saveOrUpdate(){
        String postId = post.getPostId();
        if (postId.equals("")){
            post.setPostId(null);
        }
        post.getDepartment().setDepName(dname);
        postService.saveOrUpdate(post);
        return SUCCESS;
    }


    @Override
    public Post getModel() {
        post = new Post();
        return post;
    }


    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public PostService getPostService() {
        return postService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setPostService(PostService postService) {

        this.postService = postService;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }
}
