package com.llr.im.mem.controller.dto.message;

import com.llr.im.mem.entity.Member;
import com.llr.im.mem.entity.message.Message;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class MessageListDto {

    private Long id;

    private Member sender;
    private Member receiver;

    private String content;
    private boolean receiveChk;

    private Date sendDate;
    private Date receiveDate;
}