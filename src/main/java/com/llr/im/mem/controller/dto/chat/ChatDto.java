package com.llr.im.mem.controller.dto.chat;

import com.llr.im.mem.entity.chat.Chat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {
    private Long id;

    private String roomRoomId;

    private Long writerId;
    private String writerName;

    private Long readerId;
    private String readerName;

    private String message;

    private LocalDateTime regDate;

    public ChatDto(Chat chat) {
        this.id = chat.getId();
        this.roomRoomId = chat.getRoomRoomId();
        this.writerId = chat.getWriterId();
        this.readerId = chat.getReaderId();
        this.writerName = chat.getWriterName();
        this.readerName = chat.getReaderName();
        this.message = chat.getMessage();
        this.regDate = chat.getRegDate();
    }

    public Chat toEntity() {
        return Chat.builder()
                .roomRoomId(this.roomRoomId)
                .message(this.message)
                .writerId(this.writerId)
                .writerName(this.writerName)
                .readerId(this.readerId)
                .readerName(this.readerName)
                .build();
    }
}
