package com.gathe.user.controller;


import com.gathe.user.domain.User;
import com.gathe.user.repository.impl.UserRepoStub;
import com.gathe.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepoStub service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Long id) {
        User user = service.findById(id);
        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }
            return user;

    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        User user = service.deleteById(id);
        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }
    }
}
