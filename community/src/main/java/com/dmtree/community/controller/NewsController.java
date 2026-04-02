package com.dmtree.community.controller;

import com.dmtree.community.model.News;
import com.dmtree.community.repository.NewsRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("newsList", newsRepository.findAllByOrderByCreatedAtDesc());
        return "news";
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("newsList", newsRepository.findAllByOrderByCreatedAtDesc());
        return "news";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/news/create")
    public String createNewsPage() {
        return "create-news";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/news/create")
    public String createNews(@RequestParam String title,
                             @RequestParam String content,
                             @RequestParam String imageUrl) {

        News news = new News(title, content, imageUrl);
        newsRepository.save(news);

        return "redirect:/news";
    }
}