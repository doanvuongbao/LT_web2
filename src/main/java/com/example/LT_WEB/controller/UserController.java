package com.example.LT_WEB.controller;

import com.example.LT_WEB.entity.User;
import com.example.LT_WEB.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("/{id}")
    public User update(
            @PathVariable Long id,
            @RequestBody User user) {

        User oldUser = repository.findById(id)
                .orElseThrow();

        oldUser.setFullName(user.getFullName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setPhone(user.getPhone());
        oldUser.setAddress(user.getAddress());
        oldUser.setRole(user.getRole());

        return repository.save(oldUser);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        repository.deleteById(id);

        return "Deleted Successfully";
    }
}