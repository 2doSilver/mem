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
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(length = 50)
    private String ownerId;

    @Column(length = 20)
    private String roomCode;

    @Column(length = 20, unique = true)
    private String roomName;

    @Column
    private Integer userSize;

    @Column(length = 30, unique = true)
    private String activeName;

    @Column(length = 100)
    private String roomTag;

    private LocalDateTime regDate;

    private LocalDateTime updDate;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Room_comment> room_commentList;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<RoomJoin> roomJoinList;

    @Lob
    @Column
    private byte[] coverPhoto;

//    @Builder
//    public Room(String ownerId, String roomCode, String roomName, Integer userSize, String roomTag,
//                LocalDateTime regDate, LocalDateTime updDate, byte[] coverPhoto) {
//        this.ownerId = ownerId;
//        this.roomCode = roomCode;
//        this.roomName = roomName;
//        this.userSize = userSize;
//       // this.activeName = activeName;
//        this.roomTag = roomTag;
//        this.regDate = regDate;
//        this.updDate = updDate;
//        this.coverPhoto = coverPhoto;
//    }
}
