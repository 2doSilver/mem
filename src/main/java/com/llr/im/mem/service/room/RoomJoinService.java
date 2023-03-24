package com.llr.im.mem.service.room;

import com.llr.im.mem.entity.Room;
import com.llr.im.mem.entity.RoomJoin;
import com.llr.im.mem.entity.RoomJoinRepository;
import com.llr.im.mem.entity.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoomJoinService {

    private final RoomJoinRepository roomJoinRepository;

    public void join(String activeName, String roomCode) {

        RoomJoin roomjoin = new RoomJoin();
        roomjoin.setActiveName(activeName);
        roomjoin.setRoomCode(roomCode);

        this.roomJoinRepository.save(roomjoin);
    }
}
