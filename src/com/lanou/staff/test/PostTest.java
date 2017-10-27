package com.lanou.staff.test;

import com.lanou.staff.dao.DepartmentDao;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.lanou.staff.service.PostService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * Created by dllo on 17/10/26.
 */
public class PostTest {

    @Test
    public void save(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        PostService postService = (PostService) context.getBean("postService");
        DepartmentDao departmentDao = (DepartmentDao) context.getBean("departmentDao");
        String hql = "from Department where depName=?";
        Object[] params = {"教学部"};
        List<Department> departments = departmentDao.find(hql, params);
        System.out.println(departments.get(0).getDepID());
        String depID = departments.get(0).getDepID();

        Post post = new Post("教学总监");
        post.setDepId(depID);
        postService.save(post);
        Post post1 = new Post("Java主管",depID);
        post1.setDepId(depID);
        postService.save(post1);
        Post post2 = new Post("Java讲师",depID);
        post2.setDepId(depID);
        postService.save(post2);

    }

}
