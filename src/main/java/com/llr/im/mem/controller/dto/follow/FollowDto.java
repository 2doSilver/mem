package com.llr.im.mem.controller.dto.follow;

import com.llr.im.mem.entity.follow.Follow;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class FollowDto {

    private Long memberId;

    private Long followingId;

    public Follow toEntity () {
        return Follow.builder()
                .memberId(memberId)
                .followingId(followingId)
                .build();
    }
}
