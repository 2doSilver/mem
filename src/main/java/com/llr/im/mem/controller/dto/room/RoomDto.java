package com.llr.im.mem.controller.dto.room;

import com.llr.im.mem.controller.dto.roomjoin.RoomJoinDto;
import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.entity.roomjoin.RoomJoin;
import lombok.*;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class RoomDto {

    private Long roomId;

    private String ownerId;

    private String roomName;

    private String roomTag;


    private List<String> roomTagList;   //roomTag 리스트

    private String roomCode;

    private LocalDateTime regDate;

    private  Integer userSize;

    private byte[] coverPhoto; // 이미지 파일을 받을 수 있는 필드

    private List<RoomJoin> roomJoinList;


    //카드 커버사진 인코딩
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

    public void setRoomTagList(String roomTag) {
        if (roomTag != null && !roomTag.isEmpty()) {
            this.roomTagList = Arrays.asList(roomTag.split("#"));
            this.roomTagList = this.roomTagList.stream()
                    .map(tag -> tag.trim())
                    .filter(tag -> !tag.isEmpty())
                    .collect(Collectors.toList());
        } else {
            this.roomTagList = null;
        }
    }




}
