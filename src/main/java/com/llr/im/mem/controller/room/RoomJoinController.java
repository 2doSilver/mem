package com.llr.im.mem.controller.room;

import com.llr.im.mem.controller.dto.room.RoomDto;
import com.llr.im.mem.controller.dto.roomjoin.RoomJoinDto;
import com.llr.im.mem.entity.member.Member;
import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.entity.roomjoin.RoomJoin;
import com.llr.im.mem.entity.roomjoin.RoomJoinRepository;
import com.llr.im.mem.exception.DuplicateException;
import com.llr.im.mem.service.member.room.RoomJoinService;
import com.llr.im.mem.service.member.room.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
@RequestMapping("/room")
@Slf4j
public class RoomJoinController {

    private final RoomJoinService roomJoinService;
    private final RoomService roomService;
    private final  RoomJoinRepository roomJoinRepository;

    @GetMapping(value = "/{roomId}/join")
    public String joinRoom(Model model, @PathVariable("roomId") Long roomId) {
        RoomDto roomDto = this.roomService.getRoomDto(roomId);
        model.addAttribute("room", roomDto);
        model.addAttribute("roomJoinList", roomDto.getRoomJoinList());
        model.addAttribute("roomId", roomId);
        model.addAttribute("roomJoinForm", new RoomJoinForm());
        return "room_join";

    }


    @PostMapping(value = "/{roomId}/join")
    public String joinRoom(@PathVariable("roomId") Long roomId, @Valid RoomJoinForm roomJoinForm, BindingResult bindingResult) {

        String roomCodeinJoin = roomJoinForm.getRoomCode();
        Room room = roomService.getRoom(roomId);
        String roomCodeinCreate = room.getRoomCode();

        if (!roomCodeinJoin.equals(roomCodeinCreate)) {
            bindingResult.rejectValue("roomCodeinJoin","roomCodeInCorrect", "방 입장코드가 동일하지 않습니다.");
            return "room_join";
        }
        try {
            roomJoinForm.setMemberId(99999995L);
            roomJoinForm.setRoomId(roomId);
            roomJoinService.join(roomJoinForm);
        }catch (DuplicateException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 가입된 방입니다.");
            return "room_join";
        }catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 활동명입니다.");
            return "room_join";
        }catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "room_join";
        }

        return String.format("redirect:/room/detail/%s", roomId);
    }



}
