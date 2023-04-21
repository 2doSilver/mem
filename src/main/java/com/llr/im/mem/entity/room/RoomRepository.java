package com.llr.im.mem.entity.room;


import com.llr.im.mem.controller.dto.room.RoomDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RoomRepository extends JpaRepository<Room, Long> {

    default Room editRoom(RoomDto roomDto) {
        Room room = roomDto.toEntity();
        return save(room);
    }

}
