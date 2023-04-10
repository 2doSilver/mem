package com.llr.im.mem.controller.dto.roomjoin;

import com.llr.im.mem.entity.room.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserJoinRoomListDto {

    private String activeName;

    private String roomName;
}
