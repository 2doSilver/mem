package com.llr.im.mem.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUserId(String userId);
    boolean existsByUserEmail(String userEmail);

    Member findByUserId(String userId);

    @Query(value = "SELECT * FROM MEMBER M WHERE M.ID in (SELECT F.FRIEND_ID FROM FRIEND F WHERE F.MEMBER_ID = :id)", nativeQuery = true)
    List<Member> findMemberByFriendId(@Param("id") Long memberId);

}
