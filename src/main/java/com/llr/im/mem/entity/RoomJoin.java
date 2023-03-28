package com.llr.im.mem.entity;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RoomJoin {

//    @jakarta.persistence.Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer Id;

    @Column(length = 40)
    private String activeName;

    @Column(length = 20)
    private String roomCode;

    @Id
    private Integer roomId;

    @ManyToOne
    private Room room;
}
