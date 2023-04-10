package com.llr.im.mem.service.member.room;

import com.llr.im.mem.controller.dto.roomjoin.RoomJoinDto;
import com.llr.im.mem.controller.dto.roomjoin.UserJoinRoomListDto;
import com.llr.im.mem.controller.room.RoomJoinForm;
import com.llr.im.mem.entity.member.MemberRepository;
import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.entity.room.RoomRepository;
import com.llr.im.mem.entity.roomjoin.RoomJoin;
import com.llr.im.mem.entity.roomjoin.RoomJoinRepository;
import com.llr.im.mem.exception.DuplicateException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoomJoinService {

    private final RoomJoinRepository roomJoinRepository;
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;

    public RoomJoin join(RoomJoinForm roomJoinDto) throws DuplicateException {
        // 이미 방에 가입된 사람인지 체크
        Optional<RoomJoin> roomJoin1 = roomJoinRepository.findByMemberIdAndRoomRoomId(roomJoinDto.getMemberId(), roomJoinDto.getRoomId());
        if (roomJoin1.isPresent()) {
            throw new DuplicateException();
        }

        // 같은 활동명으로 가입된 사람이 있는지 체크
        Optional<RoomJoin> roomJoin2 = roomJoinRepository.findByActiveNameAndRoomRoomId(roomJoinDto.getActiveName(), roomJoinDto.getRoomId());
        if (roomJoin2.isPresent()) {
            throw new DataIntegrityViolationException(roomJoin2.get().getActiveName());
        }

        roomJoinDto.setMember(memberRepository.findById(roomJoinDto.getMemberId()).get());
        roomJoinDto.setRoom(roomRepository.findById(roomJoinDto.getRoomId()).get());

        return this.roomJoinRepository.save(roomJoinDto.toEntity());
    }

    public List<UserJoinRoomListDto> getUserRoomList(Long userId) {

        return roomJoinRepository.findByMemberId(userId).stream()
                .map(rj -> new UserJoinRoomListDto(rj.getActiveName(), rj.getRoom().getRoomName())).collect(Collectors.toList());
    }
}
