package com.llr.im.mem.controller.dto.chat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDto {

    private String roomId;
    private Long writerId;
    private String writerName;
    private Long readerId;
    private String readerName;
    private String message;
}