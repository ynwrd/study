package com.toto.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;


public interface DbRoomMapper {

    /**
     * 可以传多条sql
     * @return
     */
    @Select({"select * from db_room"})
    List<Map<String,Object>> queryList();
}
