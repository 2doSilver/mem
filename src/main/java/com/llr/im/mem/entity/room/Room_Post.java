package com.llr.im.mem.entity.room;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
public class Room_Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @Column(length = 30, unique = true)
    private String activeName;

    @Lob
    @Column
    private byte[] postPhoto;

    @Column(length = 200)
    private String postContent;

    private LocalDateTime regDate;

    private LocalDateTime updDate;
}
