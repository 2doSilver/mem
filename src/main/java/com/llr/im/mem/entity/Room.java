package com.llr.im.mem.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100)
    private Integer roomId;

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
    private List<Comment> commentList;
}
