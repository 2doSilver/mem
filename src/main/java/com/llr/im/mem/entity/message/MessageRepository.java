package com.llr.im.mem.entity.message;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySenderIdOrderBySendDateDesc(Long senderId);

    List<Message> findByReceiverIdOrderBySendDateDesc(Long receiveId);
}
