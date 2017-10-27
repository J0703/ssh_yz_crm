package com.lanou.staff.action;

import com.lanou.staff.domain.Post;
import com.lanou.staff.service.PostService;
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
@Scope
public class PostAction extends ActionSupport implements ModelDriven<Post>{
    private Post post;

    @Qualifier("postService")
    @Autowired
    private PostService postService;

    public String findAll(){
        List<Post> posts = postService.findAll();
        System.out.println(posts);
        ServletActionContext.getRequest().setAttribute("posts",posts);
        return SUCCESS;
    }


    @Override
    public Post getModel() {
        post = new Post();
        return post;
    }
}
