package com.llr.im.mem.service.member.room;

import com.llr.im.mem.controller.dto.room.RoomDto;
import com.llr.im.mem.controller.room.RoomEditForm;
import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.entity.room.RoomRepository;
import com.llr.im.mem.entity.roomjoin.RoomJoin;
import com.llr.im.mem.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
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
                            room.getRoomTag(),null, room.getRoomCode(), room.getRegDate(), room.getUpdDate(),
                            room.getUserSize(), room.getCoverPhoto(), room.getRoomJoinList()
                    );
                    roomDto.setRoomTagList(room.getRoomTag());
                    return roomDto;
                })
                .collect(Collectors.toList());

        return roomDtoList;
    }



    public RoomDto getRoomDto(Long roomId) {
        Room room = this.roomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("Invalid room ID"));
        List<RoomJoin> roomJoinList = room.getRoomJoinList();
        RoomDto roomDto = RoomDto.builder()
                .roomId(room.getRoomId())
                .ownerId(room.getOwnerId())
                .roomName(room.getRoomName())
                .roomCode(room.getRoomCode())
                .userSize(room.getUserSize())
                .roomTag(room.getRoomTag())
                .regDate(room.getRegDate())
                .coverPhoto(room.getCoverPhoto())
                .roomJoinList(roomJoinList)
                .build();
        roomDto.setRoomTagList(room.getRoomTag());
        return roomDto;
    }

    public Room getRoom(Long roomId) {
        Optional<Room> room = this.roomRepository.findById(roomId);
        if (room.isPresent()) {
            return room.get();
        } else {
            throw new DataNotFoundException("!!!Room Not Found!!!");
        }
    }

    public List<RoomDto> search(String keyword) {

        List<RoomDto> roomDtoList = this.roomRepository.findAll().stream().filter(
                room -> room.getRoomName().contains(keyword) || room.getRoomTag().contains(keyword))
                .map(room -> {RoomDto roomDto = new RoomDto(
                        room.getRoomId(), room.getOwnerId(), room.getRoomName(),
                        room.getRoomTag(),null, room.getRoomCode(), room.getRegDate(), room.getUpdDate(),
                        room.getUserSize(), room.getCoverPhoto(), room.getRoomJoinList()
                );

                    roomDto.setRoomTagList(room.getRoomTag());
                    return roomDto;
                })
                .collect(Collectors.toList());

        return roomDtoList;
    }


    public void edit(Long roomId, RoomDto roomDto) throws IOException {

        //RoomDto roomDto = roomRepository.findById(roomId).map(RoomDto::new).orElseThrow(() -> new IllegalArgumentException("Invalid room id: " + roomId));
        Room room = roomRepository.findById(roomId).get();

        //byte[] coverPhoto = roomEditForm.getCoverPhoto().getBytes();
        //roomDto.update(roomEditForm, coverPhoto);
        roomRepository.save(roomDto.toEntity());

    }

}
