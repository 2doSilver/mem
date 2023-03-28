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

    public void join(String roomCode, String activeName ) {

        RoomJoin roomjoin = new RoomJoin();
        roomjoin.setRoomCode(roomCode);
        roomjoin.setActiveName(activeName);

        this.roomJoinRepository.save(roomjoin);
    }
}
