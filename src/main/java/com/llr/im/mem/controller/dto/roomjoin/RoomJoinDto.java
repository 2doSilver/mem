package com.llr.im.mem.controller.dto.roomjoin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class RoomJoinDto {

    private String roomCode;

    private String activeName;

    private Long roomId;

}
