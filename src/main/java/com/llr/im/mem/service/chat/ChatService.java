package com.llr.im.mem.service.chat;

import com.llr.im.mem.controller.dto.chat.ChatDto;
import com.llr.im.mem.controller.dto.chat.ChatMessageDto;
import com.llr.im.mem.entity.chat.Chat;
import com.llr.im.mem.entity.chat.ChatRepository;
import com.llr.im.mem.entity.follow.FollowRepository;
import com.llr.im.mem.entity.member.MemberRepository;
import com.llr.im.mem.entity.room.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private RoomRepository  roomRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FollowRepository followRepository;

    public List<ChatDto> getDirectChatList(Long loginId, Long memberId) {
        //갠 챗 조회
        List<Chat> chatList = chatRepository.findByWriterIdAndReaderIdOrReaderIdAndWriterIdOrderByRegDate(loginId, memberId);

        if (chatList.size() != 0) {
            return chatList.stream().map(ChatDto::new).collect(Collectors.toList());
        }

        return null;
    }

    public List<ChatDto> getRommChatList(Long roomId) {
        // 룸 챗 조회
        List<Chat> chatList = chatRepository.findByRoomRoomId(roomId + "");

        if (chatList.size() != 0) {
            return chatList.stream().map(ChatDto::new).collect(Collectors.toList());
        }

        return null;
    }

    public void save(ChatMessageDto message) {

        ChatDto chatDto = new ChatDto();
        chatDto.setRoomRoomId(message.getRoomId());
        chatDto.setMessage(message.getMessage());
        chatDto.setWriterId(message.getWriterId());
        chatDto.setWriterName(message.getWriterName());
        chatDto.setReaderId(message.getReaderId());
        chatDto.setReaderName(message.getReaderName());

        chatRepository.save(chatDto.toEntity());
    }

    @Transactional
    public void delete(ChatMessageDto message) {
        chatRepository.deleteByWriterIdAndReaderIdOrReaderIdAndWriterId(message.getWriterId(), message.getReaderId());
    }
}
