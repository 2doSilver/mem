package com.llr.im.mem.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Room_comment, Long> {
}
