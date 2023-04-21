package com.llr.im.mem.controller.dto.follow;

import com.llr.im.mem.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FollowListDto {

    private Long id;

    private String userId;
    private String userName;

    private String userBirthdate;

    private String fileName;

    public FollowListDto(Member entity) {
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.userName = entity.getUserName();
        this.userBirthdate = entity.getUserBirthdate();
        this.fileName = entity.getFileName();
    }
}
