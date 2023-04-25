package com.llr.im.mem.entity.room;

import com.llr.im.mem.entity.roomjoin.RoomJoin;
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
    private List<RoomJoin> roomJoinList;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Room_Post> room_postList;

    @Lob
    @Column
    private byte[] coverPhoto;

}
