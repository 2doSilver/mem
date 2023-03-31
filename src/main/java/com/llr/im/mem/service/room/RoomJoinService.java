package com.llr.im.mem.service.room;

import com.llr.im.mem.controller.dto.roomjoin.RoomJoinDto;
import com.llr.im.mem.entity.roomjoin.RoomJoin;
import com.llr.im.mem.entity.roomjoin.RoomJoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoomJoinService {

    private final RoomJoinRepository roomJoinRepository;

    public void join(String roomCode, String activeName ) {

//        RoomJoin roomjoin = new RoomJoin();
//        roomjoin.setRoomCode(roomCode);
//        roomjoin.setActiveName(activeName);

        RoomJoin roomjoin = new RoomJoin();



        this.roomJoinRepository.save(roomjoin);
    }
}
