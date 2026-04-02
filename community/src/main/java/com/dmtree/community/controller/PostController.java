package com.dmtree.community.controller;

import com.dmtree.community.model.*;
import com.dmtree.community.repository.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final VoteRepository voteRepository;

    public PostController(PostRepository postRepository,
                          CommentRepository commentRepository,
                          VoteRepository voteRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.voteRepository = voteRepository;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postRepository.findAllByOrderByLikesDesc());
        return "index";
    }

    @GetMapping("/post/{id}")
    public String postDetail(@PathVariable Long id, Model model) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post nicht gefunden"));

        model.addAttribute("post", post);
        model.addAttribute("comments", commentRepository.findByPostOrderByTimestampAsc(post));

        return "post";
    }

    @PostMapping("/post/{id}/comment")
    public String addComment(@PathVariable Long id,
                             @RequestParam String content,
                             Authentication auth) {

        if (auth == null) {
            return "redirect:/post/" + id + "?loginRequired=true";
        }

        Post post = postRepository.findById(id).orElseThrow();

        Comment comment = new Comment(content, auth.getName(), post);
        commentRepository.save(comment);

        return "redirect:/post/" + id;
    }

    @GetMapping("/create")
    public String createPostPage(Authentication auth, Model model) {

        if (auth == null) {
            return "redirect:/posts?loginRequired=true";
        }

        return "create";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam String title,
                             @RequestParam String content,
                             Authentication auth,
                             Model model) {

        if (auth == null) {
            return "redirect:/posts?loginRequired=true";
        }

        Post post = new Post(title, content);
        postRepository.save(post);

        return "redirect:/posts";
    }

    @PostMapping("/post/{id}/like")
    public String likePost(@PathVariable Long id, Authentication auth) {

        if (auth == null) {
            return "redirect:/posts?loginRequired=true";
        }

        Post post = postRepository.findById(id).orElseThrow();
        String email = auth.getName();

        Vote vote = voteRepository.findByUserEmailAndPost(email, post).orElse(null);

        if (vote == null) {
            vote = new Vote(email, post, true);
        } else {
            vote.setLiked(true);
        }

        voteRepository.save(vote);
        updateVotes(post);

        return "redirect:/posts";
    }

    @PostMapping("/post/{id}/dislike")
    public String dislikePost(@PathVariable Long id, Authentication auth, Model model) {

        if (auth == null) {
            return "redirect:/posts?loginRequired=true";
        }

        Post post = postRepository.findById(id).orElseThrow();
        String email = auth.getName();

        Vote vote = voteRepository.findByUserEmailAndPost(email, post).orElse(null);

        if (vote == null) {
            vote = new Vote(email, post, false);
        } else {
            vote.setLiked(false);
        }

        voteRepository.save(vote);
        updateVotes(post);

        return "redirect:/posts";
    }

    @PostMapping("/admin/comment/delete/{id}")
    public String deleteComment(@PathVariable Long id) {

        Comment comment = commentRepository.findById(id).orElseThrow();
        Long postId = comment.getPost().getId();

        commentRepository.deleteById(id);

        return "redirect:/post/" + postId;
    }

    private void updateVotes(Post post) {
        int likes = voteRepository.countByPostAndLiked(post, true);
        int dislikes = voteRepository.countByPostAndLiked(post, false);

        post.setLikes(likes);
        post.setDislikes(dislikes);

        postRepository.save(post);
    }
}