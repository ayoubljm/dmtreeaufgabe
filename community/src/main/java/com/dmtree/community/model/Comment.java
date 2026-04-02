package com.dmtree.community.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    private String userEmail;

    @ManyToOne
    private Post post;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Comment() {}

    public Comment(String content, String userEmail, Post post) {
        this.content = content;
        this.userEmail = userEmail;
        this.post = post;
    }

    // 🔥 automatisch Zeit setzen
    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Post getPost() {
        return post;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}