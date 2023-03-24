package com.llr.im.mem.controller.room;

import com.llr.im.mem.entity.Room;
import com.llr.im.mem.entity.RoomRepository;
import com.llr.im.mem.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@RequiredArgsConstructor
//DI(의존성 주입)의 방법 중에 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션
//final이 붙은 속성을 포함하는 생성자를 자동으로 생성하는 역할
@RequestMapping("/room")
@RequiredArgsConstructor
@Controller
public class RoomController {


    private final RoomService roomService;

    //Model 객체는 따로 생성할 필요없이 컨트롤러 메서드의 매개변수로 지정하기만 하면 스프링부트가 자동으로 Model 객체를 생성
    //Model 객체는 자바 클래스와 템플릿 간의 연결고리 역할
    @GetMapping("/list")
    public String list(Model model) {
        List<Room> roomList = this.roomService.getList();
        model.addAttribute("roomList", roomList);
        return "room_list";
    }

    @GetMapping(value = "/detail/{roomId}")
    public String detail(Model model, @PathVariable("roomId") Integer roomId) {

        Room room = this.roomService.getRoom(roomId);
        model.addAttribute("room", room);
        return "room_detail";
    }
}
