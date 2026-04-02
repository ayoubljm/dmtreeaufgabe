package com.dmtree.community.config;

import com.dmtree.community.model.User;
import com.dmtree.community.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            User admin = userRepository.findByEmail("admin@admin.com").orElse(null);

            if (admin == null) {

                admin = new User(
                        "admin@admin.com",
                        passwordEncoder.encode("admin123")
                );

                admin.setRole("ADMIN");
                admin.setCanChat(true); // 🔥 Admin darf immer Chat

                userRepository.save(admin);

                System.out.println("ADMIN CREATED");

            } else {

                if (!"ADMIN".equals(admin.getRole())) {
                    admin.setRole("ADMIN");
                }

                admin.setCanChat(true); // 🔥 sicherstellen

                userRepository.save(admin);

                System.out.println("ADMIN VERIFIED");
            }
        };
    }
}