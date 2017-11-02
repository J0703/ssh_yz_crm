package com.lanou.hrd.service;


import com.lanou.base_util.PageBean;
import com.lanou.hrd.domain.Post;

/**
 * Created by dllo on 17/10/20.
 */
public interface PostService {

    PageBean<Post> findAll(int pc, int ps);

    Post findById(String pid);

    void saveOrUpdate(Post post);

}
