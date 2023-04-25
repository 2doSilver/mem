package com.llr.im.mem.controller.dto.room;

import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.entity.room.Room_Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Base64;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class RoomPostDto {

    private Long postId;

    private Room room;

    private String activeName;

    private byte[] postPhoto;

    private String postContent;

    private String postTag;

    private LocalDateTime regDate;

    private LocalDateTime updDate;


    public String getPostPhotoBase64() {
        if (postPhoto != null) {
            return Base64.getEncoder().encodeToString(postPhoto);
        }
        return null;
    }

    public Room_Post toEntity() {
        return Room_Post.builder()
                .postId(postId)
                .activeName(activeName)
                .postPhoto(postPhoto)
                .postContent(postContent)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }
}
