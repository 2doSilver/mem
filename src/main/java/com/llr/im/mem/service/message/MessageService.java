package com.llr.im.mem.service.message;

import com.llr.im.mem.controller.dto.message.MessageListDto;
import com.llr.im.mem.controller.dto.message.MessageSaveDto;
import com.llr.im.mem.entity.member.Member;
import com.llr.im.mem.entity.member.MemberRepository;
import com.llr.im.mem.entity.message.Message;
import com.llr.im.mem.entity.message.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MemberRepository memberRepository;

    public String sendMessage(MessageSaveDto messageSaveDto) {
        messageSaveDto.setSender(new Member(messageSaveDto.getSenderId()));
        messageSaveDto.setReceiver(new Member(messageSaveDto.getReceiverId()));

        messageRepository.save(messageSaveDto.toEntity());
        return "전송되었습니다.";
    }

    public List<MessageListDto> getSendMessageList(Long id) {
         return messageRepository.findBySenderIdOrderBySendDateDesc(id).stream()
                 .map(m -> new MessageListDto(m.getId(), m.getSender(), m.getReceiver(),
                         m.getContent(), m.isReceiveChk(), m.getSendDate(), m.getReceiveDate()))
                 .collect(Collectors.toList());
    }

    public List<MessageListDto> getReceiveMessageList(Long userId) {
        return messageRepository.findByReceiverIdOrderBySendDateDesc(userId).stream()
                .map(m -> new MessageListDto(m.getId(), m.getSender(), m.getReceiver(),
                        m.getContent(), m.isReceiveChk(), m.getSendDate(), m.getReceiveDate()))
                .collect(Collectors.toList());
    }

    public void deleteMessage(Long msgId) {
        messageRepository.deleteById(msgId);
    }

    public MessageListDto setMessageRead(Long msgId, Boolean receiveChk) {
        if (!receiveChk) {
            messageRepository.updateReceiveChk(msgId);
        }

        Message message = messageRepository.findById(msgId).orElseThrow(NullPointerException::new);

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(message, MessageListDto.class);
    }
}
