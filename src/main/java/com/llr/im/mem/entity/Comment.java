package com.llr.im.mem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comment {


    @Column(length = 100)
    private Integer roomId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100)
    private Integer commentId;

    @Column(length = 40)
    private String writer;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime regDate;

    private LocalDateTime updDate;

    @ManyToOne
    private Room room;

}
