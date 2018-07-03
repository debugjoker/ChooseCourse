package me.debugjoker.entity;

import java.util.Date;

public class SuccessChoose {

    private long courseId;

    private long studentId;

    private int state;

    private Date createTime;

    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SuccessChoose{" +
                "courseId=" + courseId +
                ", studentId=" + studentId +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
