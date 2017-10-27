package com.lanou.staff.domain;

/**
 * Created by dllo on 17/10/25.
 */
public class Post {

    private String postId;
    private String postName;
    private String depId;

    public Post(){

    }

    public Post(String postName) {
        this.postName = postName;
    }

    public Post(String postName, String depId) {
        this.postName = postName;
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                ", depId=" + depId +
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

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }
}
