package com.llr.im.mem.controller.room;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomPostController {

    public String createPost(Model model) {
        model.addAttribute("roomPostForm", new RoomPostForm());
        return "room_post";
    }

}
