package com.dmtree.community.config;

import com.dmtree.community.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth

                        // 🔓 Öffentlich
                        .requestMatchers(
                                "/",
                                "/news",
                                "/posts",
                                "/post/**",
                                "/login",
                                "/register",
                                "/css/**"
                        ).permitAll()

                        // 🔒 nur eingeloggte dürfen posten
                        .requestMatchers(
                                "/create",
                                "/post/*/comment",
                                "/post/*/like",
                                "/post/*/dislike"
                        ).permitAll()

                        // 🔒 Chat nur eingeloggte (Feinlogik im Controller)
                        .requestMatchers("/chat").permitAll()

                        // 🔐 Admin
                        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                )

                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> {

                            String uri = request.getRequestURI();

                              if (uri.contains("/create")) {
                                response.sendRedirect("/login-required-post");
                            } else {
                                response.sendRedirect("/login");
                            }
                        })
                )

                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}