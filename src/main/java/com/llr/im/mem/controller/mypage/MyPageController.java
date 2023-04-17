package com.llr.im.mem.controller.mypage;

import com.llr.im.mem.controller.dto.follow.FollowListDto;
import com.llr.im.mem.controller.dto.member.EditProfileDto;
import com.llr.im.mem.controller.dto.member.MemberDto
        ;
import com.llr.im.mem.controller.dto.message.MessageListDto;
import com.llr.im.mem.controller.dto.roomjoin.UserJoinRoomListDto;
import com.llr.im.mem.service.follow.FollowService;
import com.llr.im.mem.service.member.MemberService;
import com.llr.im.mem.service.member.room.RoomJoinService;
import com.llr.im.mem.service.message.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private FollowService followService;

    @Autowired
    private RoomJoinService roomJoinService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/main")
    public String main(Model model) {
        Long id = 99999999L;
        // 1. 사용자
        MemberDto memberDto = memberService.getMemberInfo(id);
        model.addAttribute("member", memberDto);

        // 2-1. 팔로잉
        List<FollowListDto> followingListDtoList = followService.getFollowingList(id);
        model.addAttribute("followingList", followingListDtoList);

        // 2-2. 팔로잉
        List<FollowListDto> followerListDtoList = followService.getFollowerList(id);
        model.addAttribute("followerList", followerListDtoList);

        // 3. 방
        List<UserJoinRoomListDto> userJoinRoomListDtoList = roomJoinService.getUserRoomList(id);
        model.addAttribute("roomJoinList", userJoinRoomListDtoList);

        // 4. 수신 쪽지 목록
        List<MessageListDto> messageListDtoList = messageService.getReceiveMessageList(id);
        model.addAttribute("messageList", messageListDtoList);

        return "mypage/myPageMain";
    }

    @GetMapping("/profile/pic")
    public String profilePicSelect(Model model) {
        Long id = 99999999L;

        //
        model.addAttribute("id", id);

        return "mypage/editProfilePic";
    }

    @PostMapping("/profile/pic")
    public String profilePicEdit(@ModelAttribute EditProfileDto editProfileDto, Model model) throws Exception {
        memberService.updateProfilePic(editProfileDto);

        return "";
    }
}
