package com.llr.im.mem.service.follow;

import com.llr.im.mem.controller.dto.follow.FollowDto;
import com.llr.im.mem.controller.dto.follow.FollowListDto;
import com.llr.im.mem.entity.follow.Follow;
import com.llr.im.mem.entity.follow.FollowRepository;
import com.llr.im.mem.entity.member.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowService {
    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private MemberRepository memberRepository;

    public List<FollowListDto> getFollowingList(Long memberId) {
        return memberRepository.findMemberByFollowingId(memberId).stream()
                .map(FollowListDto::new).collect(Collectors.toList());
                //.map(member -> new FriendListDto(member.getUserId(), member.getUserName(),
                //        member.getUserBirthdate(), member.getFileName())).collect(Collectors.toList());
    }

    public List<FollowListDto> getFollowerList(Long memberId) {
        return memberRepository.findMemberByMemberId(memberId).stream()
                .map(FollowListDto::new).collect(Collectors.toList());
        //.map(member -> new FriendListDto(member.getUserId(), member.getUserName(),
        //        member.getUserBirthdate(), member.getFileName())).collect(Collectors.toList());
    }

    public FollowDto getFollowing(Long memberId, Long followingId) {
        Follow follow = followRepository.findByMemberIdAndFollowingId(memberId, followingId);

        if (follow == null)
            return new FollowDto();
        else
            return new FollowDto(follow.getId(), follow.getMemberId(), follow.getFollowingId());
    }

    public void setFollow(Long memberId, Long followingId) {
        FollowDto followDto = new FollowDto(memberId, followingId);
        Follow follow = followRepository.save(followDto.toEntity());
    }

    public void setUnFollow(Long memberId, Long followingId) {
        followRepository.deleteByMemberIdAndFollowingId(memberId, followingId);
    }
}
