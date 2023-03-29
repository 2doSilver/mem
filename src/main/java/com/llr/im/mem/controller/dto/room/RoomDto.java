package com.llr.im.mem.controller.dto.room;

import com.llr.im.mem.entity.Room;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;

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
