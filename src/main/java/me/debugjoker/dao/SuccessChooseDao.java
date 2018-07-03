package me.debugjoker.dao;

import me.debugjoker.entity.SuccessChoose;
import org.apache.ibatis.annotations.Param;

public interface SuccessChooseDao {

    /**
     * 选课成功后将结果插入successChoose表,过滤重复选课操作
     * @return
     */
    int insertSuccessChoose(@Param("courseId") long courseId,@Param("studentId") long studentId);

    SuccessChoose queryByIdwithCourse(@Param("courseId") long courseId,@Param("studentId") long studentId);
}
