package com.lanou.staff.domain;

/**
 * Created by dllo on 17/10/25.
 */
public class Post {

    private String postId;//主键 职务 id
    private String postName;// 职务名

    private Department department;

    public Post(){

    }

    public Post(String postName) {
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName +
                '}';
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
