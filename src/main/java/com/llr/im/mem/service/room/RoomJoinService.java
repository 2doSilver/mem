package com.llr.im.mem.service.room;

import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.entity.room.RoomRepository;
import com.llr.im.mem.entity.roomjoin.RoomJoin;
import com.llr.im.mem.entity.roomjoin.RoomJoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoomJoinService {

    private final RoomJoinRepository roomJoinRepository;
    private final RoomRepository roomRepository;

    public RoomJoin join(String roomCode, String activeName, Long roomId) {

        RoomJoin roomjoin = new RoomJoin();
        roomjoin.setRoomCode(roomCode);
        roomjoin.setActiveName(activeName);
        roomjoin.setRoom(roomRepository.findById(roomId).get());

        this.roomJoinRepository.save(roomjoin);
        return roomjoin;
    }

}
