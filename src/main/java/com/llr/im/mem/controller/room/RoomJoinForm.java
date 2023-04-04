package com.llr.im.mem.controller.room;

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

    private Long roomId;
}
