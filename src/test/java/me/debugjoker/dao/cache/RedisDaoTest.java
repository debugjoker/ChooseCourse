package me.debugjoker.dao.cache;

import me.debugjoker.dao.CourseDao;
import me.debugjoker.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class RedisDaoTest {

    private long id = 1001;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private CourseDao courseDao;

    @Test
    public void testCourse() throws Exception{
        Course course = redisDao.getCourse(id);
        if (course == null){
            course = courseDao.queryById(id);
            if (course != null){
                String result = redisDao.putCourse(course);
                System.out.println(result);
                course = redisDao.getCourse(id);
                System.out.println(course);
            }
        }
    }

}