package com.llr.im.mem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Room_comment {


//    @Column(length = 100)
//    private Integer roomId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(length = 40)
    private String writer;

    @Column(length = 400)
    private String content;

    private LocalDateTime regDate;

    private LocalDateTime updDate;

    @ManyToOne
    private Room room;


}
