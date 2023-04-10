package com.llr.im.mem.controller.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberDto {
    private String userId;
    private String userName;
    private String fileName;
}

