package com.lanou.staff.service;


import com.lanou.staff.domain.PageBean;
import com.lanou.staff.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public interface PostService {

    PageBean<Post> findAll(int pc, int ps);

    Post findById(String pid);

    void saveOrUpdate(Post post);

}
