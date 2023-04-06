package com.llr.im.mem.controller.friend;

import com.llr.im.mem.controller.dto.friend.FriendListDto;
import com.llr.im.mem.entity.Member;
import com.llr.im.mem.service.friend.FriendService;
import groovy.transform.AutoClone;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/list")
    public String getFriendList(Model model) {
        Long memberId = 99999999L;

        List<FriendListDto> friendListDto = friendService.getFriendList(memberId);

        model.addAttribute("friendList", friendListDto);


        return "mypage/friend_list";
    }
}
