package com.lanou.staff.test;


import com.lanou.staff.dao.DepartmentDao;
import com.lanou.staff.dao.PostDao;
import com.lanou.staff.dao.StaffDao;
import com.lanou.staff.dao.impl.DepartmentDaoImpl;
import com.lanou.staff.dao.impl.PostDaoImpl;
import com.lanou.staff.dao.impl.StaffDaoImpl;
import com.lanou.staff.domain.Department;
import com.lanou.staff.domain.Post;
import com.lanou.staff.domain.Staff;
import com.lanou.staff.service.DepartmentService;
import com.lanou.staff.service.impl.DepartmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class MainTest {


    private ApplicationContext context;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    /**
     * 插入原始数据
     **/
    @Test
    public void save() {

        DepartmentDao departmentDao = (DepartmentDao) context.getBean("departmentDao");
        StaffDao staffDao = (StaffDao) context.getBean("staffDao");
        //创建数据
        Department department = new Department("教研部");
        Post post = new Post("教学总监");
        Post post1 = new Post("Java主管");
        Post post2 = new Post("Java讲师");

        department.getPosts().add(post);
        department.getPosts().add(post1);
        department.getPosts().add(post2);

        departmentDao.save(department);//保存教学部

        Department department1 = new Department("职规部");
        Post post3 = new Post("职规主管");
        Post post4 = new Post("班主任");

        department1.getPosts().add(post3);
        department1.getPosts().add(post4);

        departmentDao.save(department1);//保存职规部

        /**
         * 教学部
         */
        // 1MySQL - crm@localhost
        Staff staff1 = new Staff("李忠仁");
        staff1.setPostID(post);//教学总监
        staffDao.save(staff1);//保存李忠仁

        // 2
        Staff staff2 = new Staff("萌小义");
        staff2.setPostID(post1);//班主任
        staffDao.save(staff2);//保存萌小义
        // 3
        Staff staff3 = new Staff("大表姐");
        staff3.setPostID(post2);//java讲师
        staffDao.save(staff3);//保存大表姐
        // 4
        Staff staff4 = new Staff("武神");
        staff4.setPostID(post2);//java讲师
        staffDao.save(staff4);//保存武神

        /**
         * 职规部
         */
        // 1
        Staff staff5 = new Staff("马琳");
        staff5.setPostID(post3);//职规主管
        staffDao.save(staff5);//保存马琳
        // 2
        Staff staff6 = new Staff("欣姐");
        staff6.setPostID(post4);//班主任
        staffDao.save(staff6);//保存欣姐
        // 3
        Staff staff7 = new Staff("竹青姐");
        staff7.setPostID(post4);//班主任
        staffDao.save(staff7);//保存竹青姐

    }


    /**
     * dao层的单元测试
     **/
    @Test
    public void testDao() {
        //查询部门集合
        DepartmentDao departDao = new DepartmentDaoImpl();

        List<Department> departments = departDao
                .findAll("from Department");

        for (Department de : departments) {
            System.out.println(de);
        }

        //查询职务表中的所有数据
        PostDao postDao = new PostDaoImpl();
        List<Post> posts = postDao.find(
                "from Post", null);

        for (Post post : posts) {
            System.out.println(post);
        }

        //查询员工表中的所有数据
        StaffDao staffDao = new StaffDaoImpl();
        List<Staff> staffs = staffDao.find(
                "from Staff", null);
        for (Staff staff : staffs) {
            System.out.println(staff + "  " + staff.getPostID());
        }

    }

    @Test
    public void testService(){
        DepartmentService departService = new DepartmentServiceImpl();
        List<Department> departments = departService.findAll();

        for (Department depart : departments){
            System.out.println("基础属性:" +depart);

            for (Post post : depart.getPosts()){
                System.out.println("职务:" + post);
            }
        }
    }

}
