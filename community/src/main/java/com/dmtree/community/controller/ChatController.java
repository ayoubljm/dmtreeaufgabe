package com.dmtree.community.controller;

import com.dmtree.community.model.ChatMessage;
import com.dmtree.community.model.User;
import com.dmtree.community.repository.ChatMessageRepository;
import com.dmtree.community.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChatController {

    private final ChatMessageRepository chatRepository;
    private final UserRepository userRepository;

    public ChatController(ChatMessageRepository chatRepository,
                          UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/chat")
    public String chat(Model model, Authentication auth) {

        // ❌ NICHT eingeloggt
        if (auth == null) {
            model.addAttribute("showPopup", true);
            model.addAttribute("popupMessage", "Bitte loggen Sie sich ein");
            return "chat";
        }

        User user = userRepository.findByEmail(auth.getName()).orElseThrow();

        // ❌ NICHT eingeladen
        if (!user.isCanChat()) {
            model.addAttribute("showPopup", true);
            model.addAttribute("popupMessage", "Warten Sie auf Einladung vom Admin");
            return "chat";
        }

        // ✅ Zugriff erlaubt
        model.addAttribute("messages", chatRepository.findAllByOrderByTimestampAsc());
        return "chat";
    }

    @PostMapping("/chat")
    public String sendMessage(@RequestParam String content,
                              Authentication auth,
                              Model model) {

        if (auth == null) {
            model.addAttribute("message", "Bitte einloggen");
            return "error";
        }

        User user = userRepository.findByEmail(auth.getName()).orElseThrow();

        if (!user.isCanChat()) {
            model.addAttribute("message", "Keine Chat-Berechtigung");
            return "error";
        }

        ChatMessage message = new ChatMessage(content, auth.getName());
        chatRepository.save(message);

        return "redirect:/chat";
    }
}