package com.llr.im.mem.entity.member;

import com.llr.im.mem.entity.room.Room;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String userPassword;

    @Column(length = 40, nullable = false)
    private String userName;

    @Column(length = 20, nullable = false)
    private String userPhone;

    @Column(nullable = false)
    private String userBirthdate;

    @Column(length = 2, nullable = false)
    private String userSex;

    @Email
    @Column(length = 100, nullable = false)
    private String userEmail;

    private String fileName;

    private String fileOriName;

    private Long fileSize;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date regDate;


    @Builder
    public Member(Long id, String userId, String userPassword, String userName, String userPhone,
                  String userBirthdate, String userSex, String userEmail, String fileName, String fileOriName, Long fileSize) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userBirthdate = userBirthdate;
        this.userSex = userSex;
        this.userEmail = userEmail;
        this.fileName = fileName;
        this.fileOriName = fileOriName;
        this.fileSize = fileSize;
    }


    public Member(Long id) {
        this.id = id;
    }
}
