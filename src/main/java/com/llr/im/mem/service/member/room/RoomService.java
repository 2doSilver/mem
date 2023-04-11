package com.llr.im.mem.service.member.room;

import com.llr.im.mem.controller.dto.room.RoomDto;
import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.entity.room.RoomRepository;
import com.llr.im.mem.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public List<RoomDto> getList() {

        List<RoomDto> roomDtoList = this.roomRepository.findAll().stream()
                .map(room -> new RoomDto(room.getRoomId(), room.getOwnerId(), room.getRoomName(),
                        room.getRoomTag(), room.getRoomCode(), room.getRegDate(), room.getUserSize(), room.getCoverPhoto()))
                .collect(Collectors.toList());

        return roomDtoList;
    }



    public Room getRoom(Long roomId) {
        Optional<Room> room = this.roomRepository.findById(roomId);
        if (room.isPresent()) {
            return room.get();
        } else {
            throw new DataNotFoundException("!!!Room Not Found!!!");
        }
    }

}
