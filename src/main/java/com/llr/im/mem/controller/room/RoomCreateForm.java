package com.llr.im.mem.controller.room;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class RoomCreateForm {


    private String ownerId;

    @NotEmpty(message = "roomCode는 필수항목입니다.")
    private String roomCode;

    @NotEmpty(message = "roomName는 필수항목입니다.")
    private String roomName;

    @NotEmpty(message = "roomTag를 설정하면 참여도가 높습니다.")
    private String roomTag;


    @NotNull(message = "userSize는 필수항목입니다.")
    private Integer userSize;

    private MultipartFile coverPhoto; // 이미지 파일을 받을 수 있는 필드

    private Long roomId;



//    @Size(min = 3, max = 25)
//    @NotEmpty(message = "activeName은 필수항목입니다.")
//    private String activeName;


}
