package com.llr.im.mem.entity.follow;

import com.llr.im.mem.entity.member.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Query(value = "SELECT M.* FROM FOLLOW F, MEMBER M WHERE F.MEMBER_ID = M.ID AND F.MEMBER_ID = :id", nativeQuery = true)
    Optional<Member> findMemberByMemberId(@Param("id") Long memberId);

    Follow findByMemberId(Long memberId);

    Follow findByMemberIdAndFollowingId(Long memberId, Long followingId);

    @Transactional
    void deleteByMemberIdAndFollowingId(Long memberId, Long followingId);
}
