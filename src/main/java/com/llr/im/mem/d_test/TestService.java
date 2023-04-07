package com.llr.im.mem.d_test;

import com.llr.im.mem.config.FileHandler;
import com.llr.im.mem.entity.member.Member;
import com.llr.im.mem.entity.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    private final MemberRepository memberRepository;

    private final FileHandler fileHandler;

    @Autowired
    public TestService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.fileHandler = new FileHandler();
    }

    public Member addBoard(
            String userId,
            MultipartFile file
    ) throws Exception {
        // 파일을 저장하고 그 Board 에 대한 list 를 가지고 있는다
        int resultCnt = 0;

        // 파일에 대해 DB에 저장하고 가지고 있을 것
            //List<Image> pictureBeans = new ArrayList<>();

        Member member = memberRepository.findByUserId(userId);

        member = fileHandler.parseFileInfo(member, file);

        return memberRepository.save(member);
    }

    public List<Member> findImages() {
        return memberRepository.findAll();
    }

    public Member findImage(String userId) {
        return memberRepository.findByUserId(userId);
    }

}
