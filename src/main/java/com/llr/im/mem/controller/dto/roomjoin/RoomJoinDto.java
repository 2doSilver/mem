package com.llr.im.mem.controller.dto.roomjoin;

import com.llr.im.mem.entity.member.Member;
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

    private Member member;

    public String getActiveName() {
        return this.activeName;
    }
}
