package com.llr.im.mem.service.member.room;

import com.llr.im.mem.controller.dto.room.RoomDto;
import com.llr.im.mem.controller.dto.room.RoomPostDto;
import com.llr.im.mem.entity.room.Room_Post;
import com.llr.im.mem.entity.room.Room_PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoomPostService {

    private final Room_PostRepository room_postRepository;

    public Room_Post create(RoomPostDto roomPostDto) {

        Room_Post room_post = room_postRepository.save(roomPostDto.toEntity());
        return room_post;
    }
}
