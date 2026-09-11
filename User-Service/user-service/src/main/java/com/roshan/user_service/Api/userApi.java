package com.roshan.user_service.Api;

import com.roshan.user_service.Entity.users;
import com.roshan.user_service.service.userservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userApi {

    private final userservice userser;

    public userApi(userservice userser) {
        this.userser = userser;
    }

    @PostMapping
    public ResponseEntity<users> create(@RequestBody users user) {
        users saved = userser.create(user);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<users> getById(@PathVariable Long id) {
        users existing = userser.getById(id);
        return ResponseEntity.ok(existing);
    }

    @GetMapping
    public ResponseEntity<List<users>> getUsersAll() {
        return ResponseEntity.ok(userser.getUsersAll());
    }
}