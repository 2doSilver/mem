package com.llr.im.mem.entity.room;

import com.llr.im.mem.entity.roomjoin.RoomJoin;
import com.llr.im.mem.entity.comment.Room_comment;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import java.util.List;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(length = 50)
    private String ownerId;

    @Column(length = 20)
    private String roomCode;

    @Column(length = 20)
    private String roomName;

    @Column(length = 50)
    private String userId;

    @Column(length = 100)
    private String roomTag;

    private LocalDateTime regDate;

    private LocalDateTime updDate;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Room_comment> room_commentList;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<RoomJoin> roomJoinList;

    @Builder
    public Room(String ownerId, String roomCode, String roomName, String userId, String roomTag,
                LocalDateTime regDate, LocalDateTime updDate) {
        this.ownerId = ownerId;
        this.roomCode = roomCode;
        this.roomName = roomName;
        this.userId = userId;
        this.roomTag = roomTag;
        this.regDate = regDate;
        this.updDate = updDate;
    }
}
