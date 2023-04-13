package com.llr.im.mem.controller.dto.member;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Getter
@Setter
public class EditProfileDto {
    private Long id;

    private String userId;

    private String userName;

    private String birthDate;

    private String userPassword;

    private String chkUserPassword;

    private String userEmail;

    private String userPhone;

    private MultipartFile file;

    private String fileName;

    private String fileOriName;

    private Long fileSize;
}
