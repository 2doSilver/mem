package com.llr.im.mem.controller.room;

import com.llr.im.mem.entity.Room;
import com.llr.im.mem.service.room.RoomJoinService;
import com.llr.im.mem.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/join")
@RequiredArgsConstructor
@Controller
public class RoomJoinController {

    private final RoomService roomService;
    private final RoomJoinService roomJoinService;

    @PostMapping("/{roomId}")
    public String joinRoom(Model model, @PathVariable("roomId") Integer roomId,@RequestParam String activeName, @RequestParam String roomCode) {


        Room room = this.roomService.getRoom(roomId);
        this.roomJoinService.join(activeName, roomCode);

        return String.format("redirect:/room/detail/%s", roomId);
    }
}
