package me.debugjoker.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Course实体类
 */
public class Course {

    private long courseId;

    private String courseName;

    private int courseNumber;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date endTime;

    private Date createTime;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreatTime() {
        return createTime;
    }

    public void setCreatTime(Date creatTime) {
        this.createTime = creatTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseNumber=" + courseNumber +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", creatTime=" + createTime +
                '}';
    }
}
