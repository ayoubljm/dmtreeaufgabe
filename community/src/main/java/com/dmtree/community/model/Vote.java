package com.dmtree.community.model;

import jakarta.persistence.*;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"userEmail", "post_id"})
        }
)
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userEmail;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    private boolean liked;

    public Vote() {}

    public Vote(String userEmail, Post post, boolean liked) {
        this.userEmail = userEmail;
        this.post = post;
        this.liked = liked;
    }

    public Long getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Post getPost() {
        return post;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

}