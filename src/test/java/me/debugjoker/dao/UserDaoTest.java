package me.debugjoker.dao;

import me.debugjoker.entity.Course;
import me.debugjoker.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void queryById() {
        long id = 2015010;
        User user = userDao.queryById(id);
        System.out.println(user);
    }

    @Test
    public void addUser() {
        long studentId = 2015010;
        String studentName = "李想";
        String className = "计科14";
        String passWord = "1234";
        int updateNumber = userDao.addUser(studentId,studentName,className,passWord);
        System.out.println(updateNumber);
    }

    @Test
    public void removeUser() {
        long studentId = 2015010000;
        int updateNumber = userDao.removeUser(studentId);
        System.out.println(updateNumber);
    }

    @Test
    public void changeUser() {
        long studentId = 99999;
        String studentName = "9996";
        String className = "99";
        String passWord = "9";
        int updateNumber = userDao.changeUser(studentId,studentName,className,passWord);
    }

    @Test
    public void queryAll() {
        List<User> courseList = userDao.queryAll();
        for (User user:courseList) {
            System.out.println(user);
        }
    }
}