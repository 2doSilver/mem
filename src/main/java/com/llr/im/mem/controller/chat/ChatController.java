package com.llr.im.mem.controller.chat;

import com.llr.im.mem.controller.dto.chat.ChatDto;
import com.llr.im.mem.controller.dto.member.MemberDto;
import com.llr.im.mem.service.chat.ChatService;
import com.llr.im.mem.service.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private MemberService memberService;

    /*@GetMapping("/chat")
    public String chatGET(Model model) {
        int ran = (int) ((Math.random() * 100) + 1);
        String userid = "userid" + ran;
        log.info("@ChatController, chat GET() {}", userid);
        model.addAttribute("userid", userid);
        return "chat/chat";
    }*/

    @GetMapping("/dm/{memberId}")
    public String openChat(@PathVariable Long memberId, Model model) {
        // 기존 채팅 내역 있으면 가져오기
        Long loginId = 99999999L;
        List<ChatDto> chatList = chatService.getDirectChatList(loginId, memberId);
        model.addAttribute("chatList", chatList);

        // 현재 writer, reader 가져오기 => save 하기 위한 것
        MemberDto writer = memberService.getMemberInfo(loginId);
        model.addAttribute("writer", writer);
        MemberDto reader = memberService.getMemberInfo(memberId);
        model.addAttribute("reader", reader);

        model.addAttribute("roomId", UUID.randomUUID().toString());

        return "chat/directMessage";
    }

    @GetMapping("/room/{roomId}/{loginId}")
    public String openRoomChat(@PathVariable Long roomId, @PathVariable Long loginId, Model model) {
        //Long loginId = 99999999L;

        List<ChatDto> chatList = chatService.getRommChatList(roomId);
        model.addAttribute("chatList", chatList);

        // 현재 writer => save 하기 위한 것
        MemberDto writer = memberService.getMemberInfo(loginId);
        model.addAttribute("writer", writer);

        return "chat/roomChat";
    }
}
