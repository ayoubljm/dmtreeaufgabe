package com.dmtree.community.repository;

import com.dmtree.community.model.Post;
import com.dmtree.community.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    // 🔹 Vote eines Users für einen Post
    Optional<Vote> findByUserEmailAndPost(String userEmail, Post post);

    // 🔥 Performance: Likes zählen
    int countByPostAndLiked(Post post, boolean liked);
}