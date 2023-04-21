package com.llr.im.mem.controller.dto.follow;

import com.llr.im.mem.entity.follow.Follow;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class FollowDto {

    private Long id;

    private Long memberId;

    private Long followingId;

    public FollowDto(Long memberId, Long followingId) {
        this.memberId = memberId;
        this.followingId = followingId;
    }

    public Follow toEntity () {
        return Follow.builder()
                .memberId(memberId)
                .followingId(followingId)
                .build();
    }
}
