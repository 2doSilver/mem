package com.llr.im.mem.controller.dto.room;

import com.llr.im.mem.entity.Room;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-21T17:15:27+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomDto toRoomDto(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomDto.RoomDtoBuilder roomDto = RoomDto.builder();

        roomDto.ownerId( room.getOwnerId() );
        roomDto.roomName( room.getRoomName() );
        roomDto.roomTag( room.getRoomTag() );
        roomDto.roomCode( room.getRoomCode() );

        return roomDto.build();
    }
}
