package com.llr.im.mem.entity.friend;

import com.llr.im.mem.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface FriendRepository extends JpaRepository<Friend, Long> {

    @Query(value = "SELECT M.* FROM FRIEND F, MEMBER M WHERE F.MEMBER_ID = M.ID AND F.MEMBER_ID = :id", nativeQuery = true)
    Optional<Member> findMemberByMemberId(@Param("id") Long memberId);
}
