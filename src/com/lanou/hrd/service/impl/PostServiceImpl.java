package com.lanou.hrd.service.impl;


import com.lanou.hrd.dao.PostDao;
import com.lanou.base_util.PageBean;
import com.lanou.hrd.domain.Post;
import com.lanou.hrd.service.PostService;

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
