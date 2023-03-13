package com.llr.im.mem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@RequiredArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(nullable = false)
    private Date birthdate;

    @Column(length = 2, nullable = false)
    private String sex;

    @Email
    @Column(length = 100, nullable = false)
    private String email;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date regDate;

    @Column(nullable = true, updatable = true)
    private Date delDate;

    @Builder
    public Member(String userId, String password, String name, String phone, Date birthdate, String sex, String email, Date regDate, Date delDate) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.birthdate = birthdate;
        this.sex = sex;
        this.email = email;
        this.regDate = regDate;
        this.delDate = delDate;
    }
}
