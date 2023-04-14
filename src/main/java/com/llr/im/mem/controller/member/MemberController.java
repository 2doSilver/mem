package com.llr.im.mem.controller.member;

import com.llr.im.mem.controller.dto.friend.FriendDto;
import com.llr.im.mem.controller.dto.member.MemberDto;
import com.llr.im.mem.service.friend.FriendService;
import com.llr.im.mem.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private FriendService friendService;

    @GetMapping("/popup/{memberId}")
    public String memberPopup(@PathVariable Long memberId, Model model) {
        // member 검색하고, 친구 검색도 해서 친구 아니면 아 친구 신청도 해야해.. 아쉬.. 여튼 친구 여부까지 가져오기
        // 낼은 친구 관련 기능 구현하기
        // 1. 친구인지 아닌지 판별
        // 2. 친구 아니면 신청하기
        // 3. 친구 신청 목록 / 한거 들어온거 관리
        // 4. 친구면 쪽지/ 채팅 아이콘 보이게?
        // 5. 쌍방 승인할 때만 친구될 수 있음
        Long loginId = 99999999L;

        // 1. Member 정보 가져오기
        MemberDto memberDto = memberService.getMemberInfo(memberId);
        model.addAttribute("member", memberDto);

        // 2. 친구 여부 가져오기
        FriendDto friendDto = friendService.getFriend(loginId, memberId);
        model.addAttribute("friend", friendDto);

        return "mypage/memberPopup";
    }
}
