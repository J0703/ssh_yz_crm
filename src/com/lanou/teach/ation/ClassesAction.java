package com.lanou.teach.ation;

import com.lanou.teach.domain.Classes;
import com.lanou.teach.domain.Course;
import com.lanou.teach.domain.PageBean;
import com.lanou.teach.service.ClassesService;
import com.lanou.teach.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;


/**
 * Created by dllo on 17/10/31.
 */
@Controller("classesAction")
@Scope
public class ClassesAction extends ActionSupport implements ModelDriven<Classes>{
    private Classes classes;

    private String pc;
    @Qualifier("classesService")
    @Autowired
    private ClassesService classesService;

    @Qualifier("courseService")
    @Autowired
    private CourseService courseService;

    public String findAll(){

        int pc = getPc();
        int ps = 3;
        PageBean<Classes> pb = classesService.findPagingAll(pc, ps);
        System.out.println(pb);
        ServletActionContext.getRequest().setAttribute("pb",pb);
        return SUCCESS;
    }

    public String findById(){
        String clazzId = classes.getClassId();
        Classes clazz= classesService.findById(clazzId);
        System.out.println(clazz);
        List<Course> courses = courseService.findAll();
        ServletActionContext.getRequest().setAttribute("clazz",clazz);
        ServletActionContext.getRequest().getSession().setAttribute("courses",courses);
        return SUCCESS;
    }

    public String showCourses(){
        List<Course> courses = courseService.findAll();
        ServletActionContext.getRequest().getSession().setAttribute("courses",courses);
        return SUCCESS;
    }

    public String classSaveOrUpdate(){

        System.out.println("class:"+classes);
        if (classes.getClassId().equals("")){
            classes.setClassId(null);
            classesService.saveOrUpdate(classes);
            return SUCCESS;
        }

        Classes clazz = classesService.findById(classes.getClassId());

        clazz.setName(classes.getName());
        clazz.getCourse().setCourseTypeId(classes.getCourse().getCourseTypeId());
        clazz.setBeginTime(classes.getBeginTime());
        clazz.setEndTime(classes.getEndTime());
        clazz.setRemark(classes.getRemark());
        classesService.saveOrUpdate(clazz);
        return SUCCESS;
    }


    @Override
    public Classes getModel() {
        classes = new Classes();
        return classes;
    }

    public int getPc() {

        String value = pc;
        System.out.println("pc:"+pc);
        if (value == null || value.trim().isEmpty()){
            return 1;
        }
        return Integer.parseInt(value);
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

}
