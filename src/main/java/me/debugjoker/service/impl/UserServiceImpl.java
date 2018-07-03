package me.debugjoker.service.impl;

import me.debugjoker.dao.UserDao;
import me.debugjoker.entity.User;
import me.debugjoker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    public int addUser(long studentId, String studentName, String className, String passWord) {

        return userDao.addUser(studentId,studentName,className,passWord);
    }

    public User infoUser(long studentId) {
        return userDao.queryById(studentId);
    }

    public int deleteUser(long studentId) {
        return userDao.removeUser(studentId);
    }

    public int changeUser(long studentId, String studentName, String className, String passWord) {
        return userDao.changeUser(studentId,studentName,className,passWord);
    }

    public List<User> queryAll() {
        return userDao.queryAll();
    }
}
