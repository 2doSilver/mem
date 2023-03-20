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
    private Integer room_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100)
    private Integer comment_id;

    @Column(length = 40)
    private String writer;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime reg_date;

    private LocalDateTime upd_date;

    @ManyToOne
    private Room room;

}
