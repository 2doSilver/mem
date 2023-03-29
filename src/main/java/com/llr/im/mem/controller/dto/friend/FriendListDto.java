package com.llr.im.mem.controller.dto.friend;

import com.llr.im.mem.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FriendListDto {


    private String userId;
    private String userName;

    private String userBirthdate;

    private String fileName;

    public FriendListDto (Member entity) {
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
        this.userBirthdate = entity.getUserBirthdate();
        this.fileName = entity.getFileName();
    }
}
