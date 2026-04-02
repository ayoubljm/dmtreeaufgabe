package com.dmtree.community.repository;

import com.dmtree.community.model.Comment;
import com.dmtree.community.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostOrderByTimestampAsc(Post post);
}