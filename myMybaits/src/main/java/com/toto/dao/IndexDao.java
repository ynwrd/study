package com.toto.dao;

import org.apache.ibatis.annotations.Select;

/**
 * index dao
 */
public interface IndexDao {

    @Select("select name from xxx where id = #{xxx}")
    String getNameById(String id);
}
