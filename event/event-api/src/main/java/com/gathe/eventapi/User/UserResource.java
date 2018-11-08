package com.gathe.eventapi.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<UserProfile> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public UserProfile retrieveUser(@PathVariable int id) {
        UserProfile userProfile = service.findUser(id);
        if(userProfile == null) {
            throw new UserNotFoundException("id-" + id);
        }
            return userProfile;

    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody UserProfile userProfile) {
        UserProfile savedUserProfile = service.save(userProfile);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUserProfile.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
