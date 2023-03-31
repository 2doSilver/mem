package com.llr.im.mem.controller.room;

import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.service.room.RoomJoinService;
import com.llr.im.mem.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/join")
@Controller
public class RoomJoinController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomJoinService roomJoinService;

    @PostMapping("/{roomId}")
    public String joinRoom(Model model, @PathVariable("roomId") Long roomId,
                           @RequestParam String roomCode,
                           @RequestParam String activeName
                           ) {

        Room room = this.roomService.getRoom(roomId);

        this.roomJoinService.join(roomCode, activeName);
        return String.format("redirect:/room/detail/%s", roomId);
    }
}