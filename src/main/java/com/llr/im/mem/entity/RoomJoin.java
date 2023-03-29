package com.llr.im.mem.entity;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RoomJoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 40)
    private String activeName;

    @Column(length = 20)
    private String roomCode;

    @Column(length = 40)
    private Long roomId;

    @ManyToOne
    private Room room;
}
