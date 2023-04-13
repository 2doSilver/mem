package com.llr.im.mem.entity.message;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySenderIdOrderBySendDateDesc(Long senderId);

    List<Message> findByReceiverIdOrderBySendDateDesc(Long receiveId);

    @Transactional
    @Modifying
    @Query("update Message set receiveChk = true, receiveDate = sysdate where id = :id")
    Integer updateReceiveChk(@Param("id") Long id);
}
