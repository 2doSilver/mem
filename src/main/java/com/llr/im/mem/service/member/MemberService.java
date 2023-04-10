package com.llr.im.mem.service.member;

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


    public MemberDto getMemberInfo(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such data"));
        return new MemberDto(member.getUserId(), member.getUserName(), member.getFileName());
    }
}

