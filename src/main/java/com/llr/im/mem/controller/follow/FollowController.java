package com.llr.im.mem.controller.follow;

import com.llr.im.mem.controller.dto.follow.FollowListDto;
import com.llr.im.mem.service.follow.FollowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/follow")
@Slf4j
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping("/list")
    public String getFriendList(Model model) {
        Long loginId = 99999999L;

        List<FollowListDto> followListDto = followService.getFollowerList(loginId);

        model.addAttribute("followList", followListDto);


        return "mypage/follow_list";
    }

    @PostMapping("/follow/{memberId}")
    public String setFollow(@PathVariable Long memberId) {
        Long loginId = 99999999L;

        followService.setFollow(loginId, memberId);

        return "redirect:/member/popup/" + memberId;
    }

    @PostMapping("/unfollow/{memberId}")
    public String setUnFollow(@PathVariable Long memberId) {
        Long loginId = 99999999L;
        log.info("======================= unFollow");
        followService.setUnFollow(loginId, memberId);

        return "redirect:/member/popup/" + memberId;
    }
}
