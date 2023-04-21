package com.llr.im.mem.entity.chat;

import com.llr.im.mem.entity.member.Member;
import com.llr.im.mem.entity.room.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue
    private Long id;

    private String roomRoomId;
    private Long writerId;
    private String writerName;
    private Long readerId;
    private String readerName;

    private String message;

    @CreationTimestamp
    private LocalDateTime regDate;
}
