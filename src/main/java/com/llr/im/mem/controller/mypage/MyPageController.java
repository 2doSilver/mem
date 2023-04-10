package com.llr.im.mem.controller.mypage;

import com.llr.im.mem.controller.dto.friend.FriendListDto;
import com.llr.im.mem.controller.dto.member.MemberDto;
import com.llr.im.mem.controller.dto.message.MessageListDto;
import com.llr.im.mem.controller.dto.room.RoomDto;
import com.llr.im.mem.controller.dto.roomjoin.RoomJoinDto;
import com.llr.im.mem.controller.dto.roomjoin.UserJoinRoomListDto;
import com.llr.im.mem.entity.roomjoin.RoomJoin;
import com.llr.im.mem.service.friend.FriendService;
import com.llr.im.mem.service.member.MemberService;
import com.llr.im.mem.service.member.room.RoomJoinService;
import com.llr.im.mem.service.member.room.RoomService;
import com.llr.im.mem.service.message.MessageService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private FriendService friendService;

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

        // 2. 친구
        List<FriendListDto> friendListDtoList = friendService.getFriendList(id);
        model.addAttribute("friendList", friendListDtoList);

        // 3. 방
        List<UserJoinRoomListDto> userJoinRoomListDtoList = roomJoinService.getUserRoomList(id);
        model.addAttribute("roomJoinList", userJoinRoomListDtoList);

        // 4. 수신 쪽지 목록
        List<MessageListDto> messageListDtoList = messageService.getReceiveMessageList(id);
        model.addAttribute("messageList", messageListDtoList);

        return "mypage/myPageMain";
    }
}
