package com.llr.im.mem.controller.dto.room;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RoomDto {

    private String ownerId;

    private String roomName;

    private String roomTag;

    private String roomCode;
}
