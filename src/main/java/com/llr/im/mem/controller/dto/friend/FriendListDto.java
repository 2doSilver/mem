package com.llr.im.mem.controller.dto.friend;

import com.llr.im.mem.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FriendListDto {

    private Long id;

    private String userId;
    private String userName;

    private String userBirthdate;

    private String fileName;

    public FriendListDto (Member entity) {
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
        this.userBirthdate = entity.getUserBirthdate();
        this.fileName = entity.getFileName();
    }
}
