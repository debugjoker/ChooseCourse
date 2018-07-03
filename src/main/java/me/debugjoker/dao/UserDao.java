package me.debugjoker.dao;

import me.debugjoker.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 根据学号查询个人信息
     * @param studentId
     * @return
     */
    public User queryById(long studentId);

    /**
     * 添加新用户
     * @param studentId
     * @param studentName
     * @param className
     * @return
     */
    public int addUser(@Param("studentId") long studentId,@Param("studentName") String studentName,
                       @Param("className") String className,@Param("passWord")String passWord);

    /**
     * 删除用户
     * @param studentId
     * @return
     */
    public int removeUser(long studentId);

    /**
     * 修改用户信息
     * @param studentId
     * @return
     */
    public int changeUser(@Param("studentId") long studentId,@Param("studentName") String studentName, @Param("className") String className,@Param("passWord")String passWord);

    List<User> queryAll();

}
