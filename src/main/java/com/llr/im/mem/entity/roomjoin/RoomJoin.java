package com.llr.im.mem.entity.roomjoin;

import com.llr.im.mem.entity.member.Member;
import com.llr.im.mem.entity.room.Room;
import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class RoomJoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String roomCode;

    @Column(length = 40)
    private String activeName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
}
