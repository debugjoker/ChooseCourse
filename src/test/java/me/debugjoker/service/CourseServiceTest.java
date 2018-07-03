package me.debugjoker.service;

import me.debugjoker.dto.CourseExecution;
import me.debugjoker.dto.Exposer;
import me.debugjoker.entity.Course;
import me.debugjoker.exception.ChooseCloseException;
import me.debugjoker.exception.ChooseException;
import me.debugjoker.exception.RepeatChooseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class CourseServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseService courseService;

    @Test
    public void getCourseList() {
        List<Course> courseList = courseService.getCourseList();
        logger.info("list={}",courseList);
    }

    @Test
    public void queryCourseById() {
        Course course = courseService.queryCourseById(1000);
        logger.info("course={}",course);
    }

    @Test
    public void exportCourseUrl() {
        Exposer exposer = courseService.exportCourseUrl(1003);
        logger.info("exposer={}",exposer);
    }

    @Test
    public void executeCourseChoose() {
        long id = 1001;
        long studentId = 152447;
        String md5 = "e8e1405de6eb6d9a6ce03f8fb2d0a3e4";
        try {
            CourseExecution courseExecution = courseService.executeCourseChoose(id,studentId,md5);
            logger.info("courseExcution={}",courseExecution);
        }catch (ChooseCloseException e){
            logger.error(e.getMessage(),e);
        } catch (RepeatChooseException e){
            logger.error(e.getMessage(),e);
        }catch (ChooseException e){
            logger.error(e.getMessage(),e);
        }
    }

    @Test
    public void testLogic() throws Exception{
        long id = 1001;
        Exposer exposer = courseService.exportCourseUrl(id);
        if (exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long studentId = 152447;
            String md5 = exposer.getMd5();
            try {
                CourseExecution courseExecution = courseService.executeCourseChoose(id,studentId,md5);
                logger.info("courseExcution={}",courseExecution);
            }catch (ChooseCloseException e){
                logger.error(e.getMessage(),e);
            } catch (RepeatChooseException e){
                logger.error(e.getMessage(),e);
            }
        }else {
            logger.warn("exposer={}",exposer);
        }
    }

}