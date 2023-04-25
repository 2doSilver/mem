package com.llr.im.mem.entity.room;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Room_Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @OneToMany(mappedBy = "room_post", cascade = CascadeType.REMOVE)
    private List<Room_Comment> room_commentList;

    @Column(length = 30, unique = true)
    private String activeName;

    @Lob
    @Column
    private byte[] postPhoto;

    @Column(length = 500)
    private String postContent;

    @Column(length = 50)
    private String postTag;

    private LocalDateTime regDate;

    private LocalDateTime updDate;
}
