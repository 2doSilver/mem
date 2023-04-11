package com.llr.im.mem.service.member.room;

import com.llr.im.mem.controller.dto.room.RoomDto;
import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.entity.room.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RequiredArgsConstructor
@Service
public class RoomCreateService {

    private final RoomRepository roomRepository;

//    public Room create(RoomDto roomDto) {
//        Room room = roomRepository.save(roomDto.toEntity());
//        return room;
//    }

    public Room create(RoomDto roomDto) throws IOException {
        Room room = roomRepository.save(roomDto.toEntity());
        return room;
    }


}
