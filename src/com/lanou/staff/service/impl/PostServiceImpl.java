package com.lanou.staff.service.impl;


import com.lanou.staff.dao.PostDao;
import com.lanou.staff.domain.PageBean;
import com.lanou.staff.domain.Post;
import com.lanou.staff.service.PostService;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public class PostServiceImpl implements PostService {
    private PostDao postDao;

    @Override
    public PageBean<Post> findAll(int pc, int ps) {
        return postDao.findPagingAll(pc,ps);
    }

    @Override
    public Post findById(String pid) {
        return postDao.findById(pid);
    }

    @Override
    public void saveOrUpdate(Post post) {
        postDao.saveOrUpdate(post);
    }


    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
