package me.debugjoker.service.impl;

import me.debugjoker.dao.CourseDao;
import me.debugjoker.dao.SuccessChooseDao;
import me.debugjoker.dto.CourseExecution;
import me.debugjoker.dto.Exposer;
import me.debugjoker.entity.Course;
import me.debugjoker.entity.SuccessChoose;
import me.debugjoker.entity.User;
import me.debugjoker.enums.CourseStateEnum;
import me.debugjoker.exception.ChooseCloseException;
import me.debugjoker.exception.ChooseException;
import me.debugjoker.exception.RepeatChooseException;
import me.debugjoker.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private SuccessChooseDao successChooseDao;

    //MD5加密混淆值
    private final String slat = "skcAsw;sjc,q01;'`l0QWcjeJ.";

    public List<Course> getCourseList() {
        return courseDao.queryAll(0, 100);
    }

    public Course queryCourseById(long courseId) {
        return courseDao.queryById(courseId);
    }

    public Exposer exportCourseUrl(long courseId) {
        Course course = courseDao.queryById(courseId);
        if (course == null) {
            //没有查到这门课
            return new Exposer(false, courseId);
        }
        Date startTime = course.getStartTime();
        Date endTime = course.getEndTime();
        Date nowTime = new Date();
        //判断选课是否开始
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            //选课未开始或者选课已经结束 不暴露选课URL地址
            return new Exposer(false, courseId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        String md5 = getMD5(courseId);
        return new Exposer(true, md5, courseId);
    }

    //注解开启事务
    @Transactional
    public CourseExecution executeCourseChoose(long courseId, long studentId, String md5) throws ChooseException, ChooseCloseException, RepeatChooseException {
        if (md5 == null || !md5.equals(getMD5(courseId))) {
            throw new ChooseException("MD5数据被篡改");
        }
        //执行选课逻辑
        Date nowTime = new Date();
        try {
            int updateCount = courseDao.reduceNumber(courseId, nowTime);
            if (updateCount <= 0) {
                //选课失败
                throw new ChooseCloseException("选课已结束");
            } else {
                int insertCount = successChooseDao.insertSuccessChoose(courseId, studentId);
                if (insertCount <= 0) {
                    throw new RepeatChooseException("重复选课");
                } else {
                    SuccessChoose successChoose = successChooseDao.queryByIdwithCourse(courseId, studentId);
                    return new CourseExecution(courseId, CourseStateEnum.SUCCESS, successChoose);
                }
            }
        } catch (ChooseCloseException e) {
            throw e;
        } catch (RepeatChooseException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ChooseException("内部逻辑异常" + e.getMessage());
        }
    }

    //根据课程id生成MD5字符串串
    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    /**
     * 通过id删除课程
     * @param courseId
     * @return
     */
    public int deleteCourseById(long courseId) {
        return courseDao.deleteCourseById(courseId);
    }

    /**
     * 查询某门课程的选课情况
     * @param courseId
     * @return
     */
    public List<User> queryChooseCourseDetail(long courseId) {
        return courseDao.queryChooseCourseDetail(courseId);
    }

    /**
     * 添加课程信息
     * @param courseName
     * @param courseNumber
     * @param startTime
     * @param endTime
     * @return
     */
    public int addCourse(String courseName, int courseNumber, String startTime, String endTime) {
        return courseDao.addCourse(courseName,courseNumber,startTime,endTime);
    }

    /**
     * 更改课程信息
     * @param courseName
     * @param courseNumber
     * @param startTime
     * @param endTime
     * @param courseId
     * @return
     */
    public int changeCourseInfo(String courseName, int courseNumber, String startTime, String endTime, long courseId) {
        return courseDao.changeCourseInfo(courseName,courseNumber,startTime,endTime,courseId);
    }

    /**
     * 模糊查询课程
     * @param courseName
     * @return
     */
    public List<Course> queryCourseBlurry(String courseName) {
        return courseDao.queryCourseBlurry(courseName);
    }
}
