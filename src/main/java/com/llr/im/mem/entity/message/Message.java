package com.llr.im.mem.entity.message;

import com.llr.im.mem.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Member sender;

    @OneToOne
    private Member receiver;

    @Column(nullable = false, length = 500)
    private String content;

    private boolean receiveChk;

    @CreatedDate
    @Column(updatable = false)
    private Date sendDate;

    private Date receiveDate;

}
