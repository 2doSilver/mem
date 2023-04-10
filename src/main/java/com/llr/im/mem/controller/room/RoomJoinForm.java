package com.llr.im.mem.controller.room;

import com.llr.im.mem.entity.member.Member;
import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.entity.roomjoin.RoomJoin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomJoinForm {

    @NotEmpty(message = "roomCode는 필수항목입니다.")
    private String roomCode;

    @Size(min = 3, max = 25)
    @NotEmpty(message = "activeName은 필수항목입니다.")
    private String activeName;

    private Long memberId;
    private Member member;

    private Long roomId;
    private Room room;

    public RoomJoin toEntity() {
        return RoomJoin.builder()
                .roomCode(roomCode)
                .activeName(activeName)
                .member(member)
                .room(room)
                .build();
    }
}
