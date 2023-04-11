package com.llr.im.mem.controller.dto.room;

import com.llr.im.mem.entity.room.Room;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Base64;

@Builder
@Setter
@Getter
public class RoomDto {

    private Long roomId;

    private String ownerId;

    private String roomName;

    private String roomTag;

    private String roomCode;

    private LocalDateTime regDate;

    private  Integer userSize;

    private byte[] coverPhoto; // 이미지 파일을 받을 수 있는 필드


    public RoomDto(Long roomId, String ownerId, String roomName, String roomTag, String roomCode,
                   LocalDateTime regDate, Integer userSize, byte[] coverPhoto) {

        this.roomId = roomId;
        this.ownerId = ownerId;
        this.roomName = roomName;
        this.roomTag = roomTag;
        this.roomCode = roomCode;
        this.regDate = regDate;
        this.userSize = userSize;
        this.coverPhoto = coverPhoto;

    }

    public String getCoverPhotoBase64() {
        if (coverPhoto != null) {
            return Base64.getEncoder().encodeToString(coverPhoto);
        }
        return null;
    }

    // private String activeName;


    public Room toEntity() {
        return Room.builder()
                .ownerId(ownerId)
                .roomName(roomName)
                .roomTag(roomTag)
                .roomCode(roomCode)
                .userSize(userSize)
                .regDate(regDate)
                .coverPhoto(coverPhoto)
                .updDate(LocalDateTime.now())
                //.activeName(activeName)
                .build();
    }
}
