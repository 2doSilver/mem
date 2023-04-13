package com.llr.im.mem.service.member;

import com.llr.im.mem.config.FileHandler;
import com.llr.im.mem.controller.dto.member.EditProfileDto;
import com.llr.im.mem.controller.dto.member.MemberDto;
import com.llr.im.mem.entity.member.Member;
import com.llr.im.mem.entity.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FileHandler fileHandler;


    public MemberDto getMemberInfo(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such data"));
        return new MemberDto(member.getId(), member.getUserId(), member.getUserName(), member.getFileName());
    }

    public void updateProfilePic(EditProfileDto editProfileDto) throws Exception {

        Member member = memberRepository.findById(editProfileDto.getId()).orElseThrow(() -> new IllegalArgumentException("no such data"));
        member = fileHandler.parseFileInfo(member, editProfileDto.getFile());

        memberRepository.save(member);
    }
}

