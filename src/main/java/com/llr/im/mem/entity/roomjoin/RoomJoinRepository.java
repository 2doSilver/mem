package com.llr.im.mem.entity.roomjoin;

import com.llr.im.mem.controller.dto.roomjoin.UserJoinRoomListDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomJoinRepository extends JpaRepository<RoomJoin, Long> {

    List<RoomJoin> findByMemberId(Long memberId);

    Optional<RoomJoin> findByMemberIdAndRoomRoomId(Long memberId, Long roomRoomId);

    Optional<RoomJoin> findByActiveNameAndRoomRoomId(String activeName, Long roomRoomId);
}
