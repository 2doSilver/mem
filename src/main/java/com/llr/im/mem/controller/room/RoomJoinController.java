package com.llr.im.mem.controller.room;

import com.llr.im.mem.service.member.room.RoomJoinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
@RequestMapping("/room")
@Slf4j
public class RoomJoinController {

    private final RoomJoinService roomJoinService;

    @GetMapping(value = "/{roomId}/join")
    public String joinRoom(Model model, @PathVariable("roomId") Long roomId) {

        model.addAttribute("roomId", roomId);
        model.addAttribute("roomJoinForm", new RoomJoinForm());
        return "room_join";

    }


    @PostMapping(value = "/{roomId}/join")
    public String joinRoom(@PathVariable("roomId") Long roomId, @Valid RoomJoinForm roomJoinForm, BindingResult bindingResult) {
        try {
            roomJoinService.join(roomJoinForm.getRoomCode(),roomJoinForm.getActiveName(), roomId);
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
