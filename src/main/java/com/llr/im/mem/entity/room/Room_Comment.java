package com.llr.im.mem.entity.room;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room_Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_post_id")
    private Room_Post room_post;

    @Column(length = 40)
    private String activeName;

    @Column(length = 400)
    private String commentContent;

    private LocalDateTime regDate;

    private LocalDateTime updDate;


}
