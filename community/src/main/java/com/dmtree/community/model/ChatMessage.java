package com.dmtree.community.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public ChatMessage() {}

    public ChatMessage(String content, String userEmail) {
        this.content = content;
        this.userEmail = userEmail;
    }

    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getContent() { return content; }
    public String getUserEmail() { return userEmail; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setContent(String content) { this.content = content; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
}