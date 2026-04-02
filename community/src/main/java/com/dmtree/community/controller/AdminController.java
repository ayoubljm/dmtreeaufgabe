package com.dmtree.community.controller;

import com.dmtree.community.model.User;
import com.dmtree.community.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🔐 Admin Panel öffnen
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/users")
    public String users() {
        return "admin-users";
    }

    // 🔍 User suchen
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/chat/search")
    public String searchUser(@RequestParam String email, Model model) {

        List<User> results = userRepository.findByEmailContainingIgnoreCase(email);

        if (results.isEmpty()) {
            model.addAttribute("chatError", "Kein User gefunden");
            return "admin-users";
        }

        model.addAttribute("results", results);
        return "admin-users";
    }

    // ✅ Chat freischalten
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/user/chat/{id}")
    public String allowChat(@PathVariable Long id, Model model) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            model.addAttribute("chatError", "User existiert nicht");
            return "admin-users";
        }

        user.setCanChat(true);
        userRepository.save(user);

        model.addAttribute("chatSuccess", "User wurde freigeschaltet");

        // 🔁 Ergebnis erneut anzeigen
        model.addAttribute("results", List.of(user));

        return "admin-users";
    }

    // ❌ Chat entfernen
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/chat/remove/{id}")
    public String removeUserFromChat(@PathVariable Long id, Model model) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            model.addAttribute("chatError", "User existiert nicht");
            return "admin-users";
        }

        user.setCanChat(false);
        userRepository.save(user);

        model.addAttribute("chatSuccess", "User wurde entfernt");

        // 🔁 Ergebnis erneut anzeigen
        model.addAttribute("results", List.of(user));

        return "admin-users";
    }
}