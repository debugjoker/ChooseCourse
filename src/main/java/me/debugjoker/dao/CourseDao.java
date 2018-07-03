package me.debugjoker.dao;

import me.debugjoker.entity.Course;
import me.debugjoker.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CourseDao {
    /**
     * 根据ID查询课程
     * @param courseId 课程Id
     * @return 课程类型数据
     */
    public Course queryById(long courseId);

    /**
     * 选课成功之后减少课程数量
     * @param courseId
     * @param chooseTime 选课时间
     * @return 操作返回影响行数
     */
    int reduceNumber(@Param("courseId") long courseId, @Param("chooseTime") Date chooseTime);

    /**
     * 根据偏移量查询所有课程数据
     * @param limit 起始位置
     * @param offset 查询数量
     * @return
     */
    List<Course> queryAll(@Param("limit") int limit, @Param("offset") int offset);

    /**
     * 通过课程ID删除课程
     * @param courseId
     * @return
     */
    int deleteCourseById(long courseId);

    /**
     * 查询某门课程的选课情况
     * @param courseId
     * @return
     */
    List<User> queryChooseCourseDetail(long courseId);

    /**
     * 添加课程信息
     * @param courseName
     * @param courseNumber
     * @param startTime
     * @param endTime
     * @return
     */
    int addCourse(@Param("courseName") String courseName,@Param("courseNumber") int courseNumber,@Param("startTime") String startTime,@Param("endTime") String endTime);

    /**
     *修改课程信息
     */
    int changeCourseInfo(@Param("courseName") String courseName,@Param("courseNumber") int courseNumber,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("courseId") long courseId);

    /**
     * 模糊查询课程
     * @param courseName
     * @return
     */
    List<Course> queryCourseBlurry(String courseName);
}
