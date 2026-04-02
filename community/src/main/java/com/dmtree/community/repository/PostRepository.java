package com.dmtree.community.repository;

import com.dmtree.community.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post> findAllByOrderByLikesDesc();
    List<Post> findAllByOrderByCreatedAtDesc();
}