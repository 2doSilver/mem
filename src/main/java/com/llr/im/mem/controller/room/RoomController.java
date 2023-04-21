package com.llr.im.mem.controller.room;

import com.llr.im.mem.controller.dto.room.RoomDto;
import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.service.member.room.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

//@RequiredArgsConstructor
//DI(의존성 주입)의 방법 중에 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션
//final이 붙은 속성을 포함하는 생성자를 자동으로 생성하는 역할
@RequestMapping("/room")
@RequiredArgsConstructor
@Controller
@Slf4j
public class RoomController {


    private final RoomService roomService;

    //Model 객체는 따로 생성할 필요없이 컨트롤러 메서드의 매개변수로 지정하기만 하면 스프링부트가 자동으로 Model 객체를 생성
    //Model 객체는 자바 클래스와 템플릿 간의 연결고리 역할
    @GetMapping("/list")
    public String list(Model model) {
        List<RoomDto> roomList = this.roomService.getList();
        model.addAttribute("roomList", roomList);
        return "room_list";
    }

    @GetMapping(value = "/detail/{roomId}")
    public String detail(Model model, @PathVariable("roomId") Long roomId) {
        RoomDto roomDto = this.roomService.getRoomDto(roomId);
        model.addAttribute("room", roomDto);
        model.addAttribute("roomJoinList", roomDto.getRoomJoinList());
        return "room_detail";
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<RoomDto> searchList = this.roomService.search(keyword);
        model.addAttribute("roomList", searchList);
        return "room_list";
    }


    @GetMapping(value = "/{roomId}/edit")
    public String edit(Model model, @PathVariable("roomId") Long roomId) {
        RoomDto roomDto = this.roomService.getRoomDto(roomId);
        RoomEditForm roomEditForm = new RoomEditForm();
        roomEditForm.setRoomId(roomDto.getRoomId());
        roomEditForm.setOwnerId(roomDto.getOwnerId());
        roomEditForm.setRoomName(roomDto.getRoomName());
        roomEditForm.setUserSize(roomDto.getUserSize());
        roomEditForm.setRoomCode(roomDto.getRoomCode());
        roomEditForm.setRoomTag(roomDto.getRoomTag());
//       roomEditForm.setCoverPhoto(roomDto.getCoverPhoto().);

        model.addAttribute("room", roomDto);
        model.addAttribute("roomEditForm", roomEditForm);

        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!{}", roomDto.getUserSize());
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!{}", roomDto.getRoomCode());
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!{}", roomDto.getRoomName());
        return "room_edit";
    }

    @PostMapping(value = "/{roomId}/edit")
    public String edit(@PathVariable("roomId") Long roomId, @Valid RoomEditForm roomEditForm, BindingResult bindingResult, Principal principal, Model model) throws IOException {


        if (bindingResult.hasErrors()) {
            // 유효성 검사에 실패한 경우 처리
            return "room_edit";
        }

        RoomDto roomDtoForCoverPhoto = this.roomService.getRoomDto(roomId);

        //coverPhoto 처리
        byte[] coverPhoto = null;
        if (roomEditForm.getCoverPhoto() != null) {
            log.info("coverphoto in");
            coverPhoto = roomEditForm.getCoverPhoto().getBytes();
        } else {
            log.info("coverphoto not in");
            coverPhoto = roomDtoForCoverPhoto.getCoverPhoto();
        }


        // RoomDto 생성
        RoomDto roomDto = new RoomDto(
                roomEditForm.getRoomId(),
                roomEditForm.getOwnerId(),
                roomEditForm.getRoomName(),
                roomEditForm.getRoomTag(),
                null,
                roomEditForm.getRoomCode(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                roomEditForm.getUserSize(),
                coverPhoto,
                null
        );

        roomService.edit(roomId, roomDto);


        model.addAttribute("room", roomDto);
        model.addAttribute("roomEditForm", roomEditForm);

        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!{}", roomDto.getRoomName());

        return String.format("redirect:/room/detail/%d", roomId);

    }

}
