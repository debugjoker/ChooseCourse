package me.debugjoker.service;

import me.debugjoker.dto.CourseExecution;
import me.debugjoker.dto.Exposer;
import me.debugjoker.entity.Course;
import me.debugjoker.entity.User;
import me.debugjoker.exception.ChooseCloseException;
import me.debugjoker.exception.ChooseException;
import me.debugjoker.exception.RepeatChooseException;

import java.util.Date;
import java.util.List;

public interface CourseService {

    /**
     * 查询所有的课程
     * @return
     */
    List<Course> getCourseList();

    /**
     * 查询一个课程记录
     * @param courseId
     * @return
     */
    Course queryCourseById(long courseId);

    /**
     * 选课开始时暴露选课地址，未开始时输出系统时间和秒杀时间
     * @param courseId
     */
    Exposer exportCourseUrl(long courseId);

    /**
     * 开始执行选课操作
     */
    CourseExecution executeCourseChoose(long courseId, long studentId, String md5) throws ChooseException,ChooseCloseException,RepeatChooseException;

    /**
     * 通过课程ID删除课程
     * @param courseId
     * @return
     */
    int deleteCourseById(long courseId);

    /**
     * 查询选课结果
     * @param courseId
     * @return
     */
    List<User> queryChooseCourseDetail(long courseId);

    /**
     * 添加课程
     * @param courseName
     * @param courseNumber
     * @param startTime
     * @param endTime
     * @return
     */
    int addCourse(String courseName, int courseNumber, String startTime, String endTime);

    /**
     * 改变课程信息
     * @param courseName
     * @param courseNumber
     * @param startTime
     * @param endTime
     * @param courseId
     * @return
     */
    int changeCourseInfo(String courseName,int courseNumber,String startTime,String endTime,long courseId);

    /**
     * 模糊查询
     * @param courseName
     * @return
     */
    List<Course> queryCourseBlurry(String courseName);
}
