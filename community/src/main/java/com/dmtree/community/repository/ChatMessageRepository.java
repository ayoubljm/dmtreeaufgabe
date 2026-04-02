package com.dmtree.community.repository;

import com.dmtree.community.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    // 🔥 Chat chronologisch anzeigen
    List<ChatMessage> findAllByOrderByTimestampAsc();
}