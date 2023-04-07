package com.llr.im.mem.controller.dto.room;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class RoomDto {

    private Long roomId;

    private String ownerId;

    private String roomName;

    private String roomTag;

    private String roomCode;

    private LocalDateTime regDate;
}
