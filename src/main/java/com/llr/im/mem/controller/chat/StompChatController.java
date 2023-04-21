package com.llr.im.mem.controller.chat;

import com.llr.im.mem.controller.dto.chat.ChatMessageDto;
import com.llr.im.mem.service.chat.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StompChatController {

    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
    private final ChatService chatService;

    //Client가 SEND할 수 있는 경로
    //stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    //"/pub/chat/enter"
    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMessageDto message){
        message.setMessage(message.getWriterName() + "님이 채팅방에 참여하였습니다.");
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageDto message){

        //db저장
        chatService.save(message);

        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @MessageMapping(value = "/chat/bye")
    public void bye(ChatMessageDto message){

        //db삭제
        chatService.delete(message);
    }

    @MessageMapping(value = "/chat/out")
    public void out(ChatMessageDto message) {
        message.setMessage(message.getWriterName() + "님이 채팅방을 나가셨습니다.");
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}