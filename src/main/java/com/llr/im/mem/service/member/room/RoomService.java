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
                .map(room -> {
                    RoomDto roomDto = new RoomDto(
                            room.getRoomId(), room.getOwnerId(), room.getRoomName(),
                            room.getRoomTag(),null, room.getRoomCode(), room.getRegDate(),
                            room.getUserSize(), room.getCoverPhoto(), room.getRoomJoinList()
                    );
                    roomDto.setRoomTagList(room.getRoomTag());
                    return roomDto;
                })
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

    public RoomDto getRoomDto(Long roomId) {
        Room room = this.roomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));
        RoomDto roomDto = RoomDto.builder()
                .roomId(room.getRoomId())
                .ownerId(room.getOwnerId())
                .roomName(room.getRoomName())
                .roomTag(room.getRoomTag())
                .regDate(room.getRegDate())
                .coverPhoto(room.getCoverPhoto())
                .build();
        roomDto.setRoomTagList(room.getRoomTag());
        return roomDto;
    }

    public List<RoomDto> search(String keyword) {

        List<RoomDto> roomDtoList = this.roomRepository.findAll().stream().filter(
                room -> room.getRoomName().contains(keyword) || room.getRoomTag().contains(keyword))
                .map(room -> {RoomDto roomDto = new RoomDto(
                        room.getRoomId(), room.getOwnerId(), room.getRoomName(),
                        room.getRoomTag(),null, room.getRoomCode(), room.getRegDate(),
                        room.getUserSize(), room.getCoverPhoto(), room.getRoomJoinList()
                );

                    roomDto.setRoomTagList(room.getRoomTag());
                    return roomDto;
                })
                .collect(Collectors.toList());

        return roomDtoList;
    }

}
