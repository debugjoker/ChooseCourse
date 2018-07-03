package me.debugjoker.enums;

/**
 * 数据字典枚举
 */
public enum CourseStateEnum {
    SUCCESS (1,"选课成功"),
    END(0,"选课已结束"),
    REPEAT_CHOOSE(-1,"重复选课"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private int state;

    private String stateInfo;

    CourseStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
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

    public static CourseStateEnum stateEnum(int index){
        for (CourseStateEnum stateEnum : values()){
            if (stateEnum.getState() == index){
                return stateEnum;
            }
        }
        return null;
    }
}
