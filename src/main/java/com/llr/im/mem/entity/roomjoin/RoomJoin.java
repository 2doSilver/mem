package com.llr.im.mem.entity.roomjoin;

import com.llr.im.mem.entity.room.Room;
import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class RoomJoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 20)
    private String roomCode;

    @Column(length = 40, unique = true)
    private String activeName;
//
//    @Column(length = 40)
//    private Long roomId;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @Builder
    public RoomJoin(String activeName, String roomCode) {
        this.activeName = activeName;
        this.roomCode = roomCode;

    }
}
