package com.lanou.trd.service.impl;

import com.lanou.trd.dao.CourseDao;
import com.lanou.trd.domain.Course;
import com.lanou.trd.service.CourseService;

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
