package com.llr.im.mem.service.friend;

import com.llr.im.mem.controller.dto.friend.FriendDto;
import com.llr.im.mem.controller.dto.friend.FriendListDto;
import com.llr.im.mem.entity.friend.Friend;
import com.llr.im.mem.entity.friend.FriendRepository;
import com.llr.im.mem.entity.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendService {
    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private MemberRepository memberRepository;

    public List<FriendListDto> getFriendList(Long memberId) {
        return memberRepository.findMemberByFriendId(memberId).stream()
                .map(FriendListDto::new).collect(Collectors.toList());
                //.map(member -> new FriendListDto(member.getUserId(), member.getUserName(),
                //        member.getUserBirthdate(), member.getFileName())).collect(Collectors.toList());
    }

    public FriendDto getFriend(Long memberId, Long friendId) {
        Friend friend = friendRepository.findByMemberIdAndFriendId(memberId, friendId);

        return new FriendDto(friend.getMemberId(), friend.getFriendId());
    }
}
