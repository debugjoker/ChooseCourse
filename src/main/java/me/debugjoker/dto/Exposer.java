package me.debugjoker.dto;

/**
 * 暴露选课地址DTO
 */
public class Exposer {

    /*是否开启选课*/
    private boolean isExposed;
    /* 加密措施*/
    private String md5;
    /*课程id*/
    private long courseId;
    /*系统当前时间*/
    private long now;
    /*选课开始时间*/
    private long start;
    /*选课结束时间*/
    private long end;

    /**
     * 选课开始 传入true MD5 id
     * @param isExposed
     * @param md5
     * @param courseId
     */
    public Exposer(boolean isExposed, String md5, long courseId) {
        this.isExposed = isExposed;
        this.md5 = md5;
        this.courseId = courseId;
    }

    /**
     * 选课未开始或者已经结束 传入false id 当前时间 开始时间 结束时间
     * @param isExposed
     * @param now
     * @param start
     * @param end
     */
    public Exposer(boolean isExposed,long courseId, long now, long start, long end) {
        this.isExposed = isExposed;
        this.courseId = courseId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    /**
     * 没有这门课 返回false和id
     * @param isExposed
     * @param courseId
     */
    public Exposer(boolean isExposed, long courseId) {
        this.isExposed = isExposed;
        this.courseId = courseId;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public void setExposed(boolean exposed) {
        isExposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "isExposed=" + isExposed +
                ", md5='" + md5 + '\'' +
                ", courseId=" + courseId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
