package com.lanou.hrd.test;

import com.lanou.hrd.domain.Department;
import com.lanou.hrd.domain.Post;
import com.lanou.hrd.service.DepartmentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/10/26.
 */
public class DepartTest {

    @Test
    public void save(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        DepartmentService service = (DepartmentService) context.getBean("departmentService");
        Department department = new Department("质询部");
        Department department1 = new Department("职规部");
        Department department2 = new Department("教研部");
        Department department3 = new Department("就业部");
        Department department4 = new Department("人力支援部");

        Post post = new Post("教学总监");
        Post post1 = new Post("Java主管");
        Post post2 = new Post("Java讲师");

        department2.getPosts().add(post);
        department2.getPosts().add(post1);
        department2.getPosts().add(post2);

        service.save(department2);//保存教学部

        Post post3 = new Post("职规主管");
        Post post4 = new Post("班主任");

        department1.getPosts().add(post3);
        department1.getPosts().add(post4);

        service.save(department1);//保存职规部

        service.save(department);
        service.save(department3);
        service.save(department4);

    }

}
