package com.example.travel_backend.component;

import com.example.travel_backend.entity.User;
import com.example.travel_backend.enums.Role;
import com.example.travel_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    @Lazy
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0){
            User user = new User();
            user.setFullName("Developer");
            user.setPhoneNumber("+998999701899");
            user.setEmail("avazabsamtov7@gmail.com");
            user.setUsername("developer");
            user.setPassword(passwordEncoder.encode("dev123!@#321#@!"));
            user.setRole(Role.DEVELOPER);
            userRepository.save(user);
            System.out.println("Developer created");
        }
    }
}
