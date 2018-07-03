package me.debugjoker.dao;

import me.debugjoker.entity.Course;
import me.debugjoker.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class CourseDaoTest {

    @Autowired  //注入依赖
    private CourseDao courseDao;
    @Test
    public void queryById() {
        long id = 1000;
        Course course = courseDao.queryById(id);
        System.out.println(course.getCourseName());
        System.out.println(course);
    }

    @Test
    public void reduceNumber() {
        long courseId = 1002;
        Date chooseTime = new Date();
        int updateCount = courseDao.reduceNumber(courseId,chooseTime);
        System.out.println("updateCount= " + updateCount);
    }

    @Test
    public void queryAll() {
        List<Course> courseList = courseDao.queryAll(0,100);
        for (Course course:courseList) {
            System.out.println(course);
        }
    }

    @Test
    public void deleteCourse(){
        long courseId = 1005;
        int result = courseDao.deleteCourseById(courseId);
        System.out.println(result);
    }

    @Test
    public void chooseCourseDetail(){
        long courseId = 1000;
        List<User> list = courseDao.queryChooseCourseDetail(courseId);
        for (User user:list){
            System.out.println(user);
        }
    }

    @Test
    public void addCourse(){
        int result = courseDao.addCourse("spring实战",33,"2018-06-01 00:00:0","2018-06-01 00:00:0");
        System.out.println(result);
    }

    @Test
    public void changeCourseInfo(){
        int result = courseDao.changeCourseInfo("html5",33,"2018-06-01 00:00:00","2018-06-01 00:00:00",1007);
        System.out.println(result);
    }

    @Test
    public void queryCourse(){
        List<Course> list = courseDao.queryCourseBlurry("数");
        for (Course course:list){
            System.out.println(course);
        }
    }
}