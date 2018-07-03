package me.debugjoker.entity;

public class User {

    private long userId;

    private long studentId;

    private String studentName;

    private String studentClassName;

    private String studentPassword;

    private boolean identity;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClassName() {
        return studentClassName;
    }

    public void setStudentClassName(String studentClassName) {
        this.studentClassName = studentClassName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public boolean isIdentity() {
        return identity;
    }

    public void setIdentity(boolean identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClassName='" + studentClassName + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", identity=" + identity +
                '}';
    }
}
