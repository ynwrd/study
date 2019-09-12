package com.toto.service;

import com.toto.mapper.DbRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoomService {

    @Autowired
    private DbRoomMapper roomMapper;

    public List<Map<String,Object>> getRoomList(){
        return roomMapper.queryList();
    }
}
