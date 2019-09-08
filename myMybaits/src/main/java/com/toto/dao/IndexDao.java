package com.toto.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * index dao
 */
public interface IndexDao {

    @Select("select name from xxx where id = #{xxx}")
    String getNameById(String id);

    @Update("update xxx set value = #{id} where id = 1")
    void updateInfo(String id);
}
