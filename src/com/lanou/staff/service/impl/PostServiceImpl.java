package com.lanou.staff.service.impl;


import com.lanou.staff.dao.PostDao;
import com.lanou.staff.domain.Post;
import com.lanou.staff.service.PostService;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public class PostServiceImpl implements PostService {
    private PostDao postDao;

    @Override
    public List<Post> findAll() {
        String hql = "from Post";
        return postDao.findAll(hql);
    }
    @Override
    public void save(Post post) {
        postDao.save(post);
    }

    @Override
    public List<Post> find(String hql, Object[] params) {

        return postDao.find(hql,params);
    }

    @Override
    public Post findById(int pid) {
        return postDao.findById(pid);
    }


    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
