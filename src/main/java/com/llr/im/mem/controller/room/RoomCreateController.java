package com.llr.im.mem.controller.room;

import com.llr.im.mem.controller.dto.room.RoomDto;
import com.llr.im.mem.entity.room.Room;
import com.llr.im.mem.service.member.room.RoomCreateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping("/room")
@Slf4j
public class RoomCreateController {

    private final RoomCreateService roomCreateService;

    @GetMapping(value = "/create")
    public String createRoom(Model model) {

        model.addAttribute("roomCreateForm", new RoomCreateForm());
        return "room_create";
    }

    @PostMapping(value = "/create")
    public String createRoom( @Valid RoomCreateForm roomCreateForm, BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            return "room_create";
        }
        try {

            // RoomDto 생성
            RoomDto roomDto = new RoomDto(
                    roomCreateForm.getRoomId(),
                    roomCreateForm.getOwnerId(),
                    roomCreateForm.getRoomName(),
                    roomCreateForm.getRoomTag(),
                    roomCreateForm.getRoomCode(),
                    LocalDateTime.now(),
                    roomCreateForm.getUserSize(),
                    roomCreateForm.getCoverPhoto().getBytes()
            );

            Room createdRoom = roomCreateService.create(roomDto);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("createFailed", "이미 존재합니다.");
            return "room_create";

        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("createFailed", e.getMessage());
            return "room_create";
        }


        //return String.format("redirect:/room/detail/%s", roomId);
        return "redirect:/room/list";
        //return "redirect:/room/detail/" + roomId;
    }


}
