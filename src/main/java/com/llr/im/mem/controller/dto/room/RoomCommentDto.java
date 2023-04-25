package com.llr.im.mem.controller.dto.room;

import com.llr.im.mem.entity.room.Room_Comment;
import com.llr.im.mem.entity.room.Room_Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class RoomCommentDto {

    private Long commentId;

    private Room_Post room_post;

    private String activeName;

    private String commentContent;

    private LocalDateTime regDate;

    private LocalDateTime updDate;


    public Room_Comment toEntity() {
        return Room_Comment.builder()
                .commentId(commentId)
                .activeName(activeName)
                .commentContent(commentContent)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }

}
