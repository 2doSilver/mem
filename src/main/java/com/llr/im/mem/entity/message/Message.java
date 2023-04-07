package com.llr.im.mem.entity.message;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.llr.im.mem.entity.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
