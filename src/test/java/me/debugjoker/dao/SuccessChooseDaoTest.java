package me.debugjoker.dao;

import me.debugjoker.entity.SuccessChoose;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class SuccessChooseDaoTest {

    @Autowired
    private SuccessChooseDao successChooseDao;
    @Test
    public void insertSuccessChoose() {
        long courseId = 1001;
        long studentId = 2015013;
        int updateCount = successChooseDao.insertSuccessChoose(courseId,studentId);
        System.out.println(updateCount);
    }

    @Test
    public void queryByIdwithCourse() {
        long courseId = 1000;
        long studentId = 201501;
        SuccessChoose successChoose = successChooseDao.queryByIdwithCourse(courseId,studentId);
        System.out.println(successChoose);
        System.out.println(successChoose.getCourse());
    }
}