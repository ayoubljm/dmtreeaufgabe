package com.dmtree.community.repository;

import com.dmtree.community.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    // 🔥 neueste News zuerst
    List<News> findAllByOrderByCreatedAtDesc();
}