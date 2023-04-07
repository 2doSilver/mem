package com.llr.im.mem.controller.dto.message;

import com.llr.im.mem.entity.Member;
import com.llr.im.mem.entity.message.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MessageSaveDto {

    private Long senderId;
    private String senderUserId;
    private Long receiverId;
    private String receiverUserId;

    private Member sender;
    private Member receiver;

    private String content;
    private boolean receiveChk;

    public Message toEntity() {
        return Message.builder()
                .content(content)
                .receiveChk(receiveChk)
                .sender(sender)
                .receiver(receiver)
                .build();
    }
}
