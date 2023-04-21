package com.llr.im.mem.entity.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    //List<Chat> findByChatRoomId(Long chatRoomId);

    @Query("select c from Chat c where (c.writerId = :writerId and c.readerId = :readerId) " +
            "or (c.writerId = :readerId and c.readerId = :writerId) order by c.regDate")
    List<Chat> findByWriterIdAndReaderIdOrReaderIdAndWriterIdOrderByRegDate
            (@Param("writerId") Long writerId, @Param("readerId") Long readerId);

    List<Chat> findByRoomRoomId(String roomId);

    @Modifying
    @Query("delete from Chat c where (c.writerId = :writerId and c.readerId = :readerId) " +
            "or (c.writerId = :readerId and c.readerId = :writerId)")
    void deleteByWriterIdAndReaderIdOrReaderIdAndWriterId(@Param("writerId") Long writerId, @Param("readerId") Long readerId);
}
