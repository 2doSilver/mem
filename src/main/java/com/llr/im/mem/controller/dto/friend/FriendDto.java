package com.llr.im.mem.controller.dto.friend;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class FriendDto {

    private Long memberId;

    private Long friendId;
}
