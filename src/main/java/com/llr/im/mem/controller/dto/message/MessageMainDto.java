package com.llr.im.mem.controller.dto.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class MessageMainDto {
    private Long receiverId;
    private String receiverName;
    private String receiverUserId;
}
