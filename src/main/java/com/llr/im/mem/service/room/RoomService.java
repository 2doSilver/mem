package com.llr.im.mem.service.room;

import com.llr.im.mem.entity.Room;
import com.llr.im.mem.entity.RoomRepository;
import com.llr.im.mem.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> getList() {
        return this.roomRepository.findAll();
    }

    public Room getRoom(Long roomId) {
        Optional<Room> room = this.roomRepository.findById(roomId);
        if (room.isPresent()) {
            return room.get();
        } else {
            throw new DataNotFoundException("!!!Room Not Found!!!");
        }
    }

}
