package com.lanou.teach.service.impl;

import com.lanou.teach.dao.CourseDao;
import com.lanou.teach.domain.Course;
import com.lanou.teach.service.CourseService;

import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
public class CourseServiceImpl implements CourseService{

    private CourseDao courseDao;
    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
}
