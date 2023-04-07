package com.llr.im.mem.entity.member;

import com.llr.im.mem.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUserId(String userId);
    boolean existsByUserEmail(String userEmail);

    Member findByUserId(String userId);

    @Query(value = "SELECT * FROM MEMBER M WHERE M.ID in (SELECT F.FRIEND_ID FROM FRIEND F WHERE F.MEMBER_ID = :id)", nativeQuery = true)
    List<Member> findMemberByFriendId(@Param("id") Long memberId);
}
