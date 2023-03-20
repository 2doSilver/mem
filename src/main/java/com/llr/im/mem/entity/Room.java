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
    private Integer room_id;

    @Column(length = 50)
    private String owner_id;

    @Column(length = 20)
    private String room_code;

    @Column(length = 20)
    private String room_name;

    @Column(length = 50)
    private String user_id;

    @Column(length = 100)
    private String room_tag;

    private LocalDateTime reg_date;

    private LocalDateTime upd_date;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;
}
