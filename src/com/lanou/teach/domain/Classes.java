package com.lanou.teach.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by dllo on 17/10/31.
 */
public class Classes {

    private String classId;
    private String name;
    private Timestamp beginTime;
    private Timestamp endTime;
    private String status;
    private Integer totalCount;
    private Integer upgradeCount;
    private Integer changeCount;
    private Integer runoffCount;
    private String remark;
    private Timestamp uploadTime;
    private String uploadPath;
    private String uploadFilename;

    private Course course;

    public Classes() {
    }

    public Classes(String classId, String name, Timestamp beginTime, Timestamp endTime, String status, Integer totalCount,
                   Integer upgradeCount, Integer changeCount, Integer runoffCount, String remark, Timestamp uploadTime,
                   String uploadPath, String uploadFilename) {
        this.classId = classId;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadTime = uploadTime;
        this.uploadPath = uploadPath;
        this.uploadFilename = uploadFilename;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classId='" + classId + '\'' +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", totalCount=" + totalCount +
                ", upgradeCount=" + upgradeCount +
                ", changeCount=" + changeCount +
                ", runoffCount=" + runoffCount +
                ", remark='" + remark + '\'' +
                ", uploadTime=" + uploadTime +
                ", uploadPath='" + uploadPath + '\'' +
                ", uploadFilename='" + uploadFilename + '\'' +
                '}';
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(Integer upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public Integer getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(Integer runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFilename() {
        return uploadFilename;
    }

    public void setUploadFilename(String uploadFilename) {
        this.uploadFilename = uploadFilename;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }
}
