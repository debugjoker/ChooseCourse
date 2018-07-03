package me.debugjoker.dto;

import me.debugjoker.entity.SuccessChoose;
import me.debugjoker.enums.CourseStateEnum;

/**
 * 选课之后结果对象封装
 */
public class CourseExecution {

    private long courseId;
    //选课结果状态
    private int state;
    //状态表示
    private String stateInfo;
    //选课成功对象
    private SuccessChoose successChoose;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessChoose getSuccessChoose() {
        return successChoose;
    }

    public void setSuccessChoose(SuccessChoose successChoose) {
        this.successChoose = successChoose;
    }

    //成功时返回
    public CourseExecution(long courseId, CourseStateEnum stateEnum, SuccessChoose successChoose) {
        this.courseId = courseId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successChoose = successChoose;
    }

    //失败时返回
    public CourseExecution(long courseId, CourseStateEnum stateEnum) {
        this.courseId = courseId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    @Override
    public String toString() {
        return "CourseExecution{" +
                "courseId=" + courseId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successChoose=" + successChoose +
                '}';
    }
}
