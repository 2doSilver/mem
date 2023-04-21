package com.llr.im.mem.controller.room;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class RoomEditForm {

    private String ownerId;

    private String roomCode;

    private String roomName;

    private String roomTag;

    private Integer userSize;

    private MultipartFile coverPhoto; // 이미지 파일을 받을 수 있는 필드

    private Long roomId;


}
