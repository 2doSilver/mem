package com.llr.im.mem.controller.message;

import com.llr.im.mem.controller.dto.message.MessageListDto;
import com.llr.im.mem.controller.dto.message.MessageMainDto;
import com.llr.im.mem.controller.dto.message.MessageSaveDto;
import com.llr.im.mem.service.message.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/message")
@Slf4j
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("/main")
    public String view(MessageMainDto messageMainDto, Model model) {

        model.addAttribute("messageMainDto", messageMainDto);

        return "mypage/message";
    }

    @PostMapping("/send")
    public String send(MessageSaveDto messageSaveDto, Model model) {
        messageSaveDto.setSenderId(99999999L);

        String result = messageService.sendMessage(messageSaveDto);

        model.addAttribute("result", result);

        return "mypage/messageResult";
    }

    @GetMapping("/{userId}/sendList")
    public String sendMessageList(@PathVariable  Long userId, Model model) {
        List<MessageListDto> list = messageService.getSendMessageList(userId);
        model.addAttribute("messageList", list);

        return "mypage/messageSendList";
    }

    @GetMapping("/{userId}/receiveList")
    public String receiveMessageList(@PathVariable  Long userId, Model model) {
        List<MessageListDto> list = messageService.getReceiveMessageList(userId);
        model.addAttribute("messageList", list);

        return "mypage/messageReceiveList";
    }

    @DeleteMapping("/cancel/{msgId}")
    public String messageCancel(@PathVariable Long msgId) {
        messageService.deleteMessage(msgId);

        return "redirect:/message/" + 99999999 + "/list";
    }
}
