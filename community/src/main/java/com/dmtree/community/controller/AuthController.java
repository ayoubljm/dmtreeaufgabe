package com.dmtree.community.controller;

import com.dmtree.community.model.User;
import com.dmtree.community.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login-required-post")
    public String postLoginRequired(Model model) {
        model.addAttribute("message", "Bitte loggen Sie sich ein, um einen Post zu erstellen");
        return "error";
    }

    @GetMapping("/login-required-chat")
    public String chatLoginRequired(Model model) {
        model.addAttribute("message", "Bitte loggen Sie sich ein und warten Sie auf die Einladung vom Admin");
        return "error";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/register")
    public String register(@RequestParam String email,
                           @RequestParam String password,
                           Model model) {

        if (userRepository.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Diese Email ist bereits registriert");
            return "register";
        }

        User user = new User(email, passwordEncoder.encode(password));
        user.setRole("USER");

        userRepository.save(user);

        return "redirect:/login";
    }
}