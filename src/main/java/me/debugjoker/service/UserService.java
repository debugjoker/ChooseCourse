package me.debugjoker.service;

import me.debugjoker.entity.User;

import java.util.List;

public interface UserService {

    //添加用户
    int addUser(long studentId,String studentName, String className,String passWord);

    //查询用户信息
    User infoUser(long studentId);

    //删除用户
    int deleteUser(long studentId);

    //修改用户信息
    int changeUser(long studentId,String studentName, String className,String passWord);

    //查询所有用户信息
    List<User> queryAll();
}
