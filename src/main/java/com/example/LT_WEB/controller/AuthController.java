package com.example.LT_WEB.controller;

import com.example.LT_WEB.config.JwtUtil;
import com.example.LT_WEB.dto.LoginRequest;
import com.example.LT_WEB.dto.RegisterRequest;
import com.example.LT_WEB.entity.User;
import com.example.LT_WEB.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository repository;

    public AuthController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    public User register(
            @RequestBody RegisterRequest request) {

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setRole("USER");

        return repository.save(user);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request) {

        User user = repository
                .findByEmail(request.getEmail())
                .orElse(null);

        if(user == null)
            return "Email not found";

        if(!user.getPassword()
                .equals(request.getPassword()))
            return "Wrong password";

        return JwtUtil.generateToken(
                user.getEmail());
    }
}