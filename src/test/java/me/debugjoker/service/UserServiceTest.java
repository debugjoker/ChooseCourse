package me.debugjoker.service;


import me.debugjoker.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-dao.xml"})
public class UserServiceTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void addUser() {
        int result = userDao.addUser(1000,"dcs","css","cssdw");
        System.out.println(result);
    }

    @Test
    public void infoUser() {

    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void changeUser() {
    }
}