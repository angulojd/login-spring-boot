package com.example.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.login.models.UserModel;
import com.example.login.services.UserService;


@RestController
@Validated
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserModel user) {
        Map<String, Object> savedUser = userService.saveUser(user);
        int status = (int) savedUser.get("statusCode");
        if (status != 200) {
            return new ResponseEntity<>(savedUser, HttpStatus.resolve(status));
        }
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/auth")
    public ResponseEntity<?> authUser(@RequestBody UserModel user) {
        Map<String, Object> authUser = userService.authUser(user.getUsername(), user.getPassword());
        int status = (int) authUser.get("statusCode");
        if (status != 200) {
            return new ResponseEntity<>(authUser, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(authUser, HttpStatus.OK);
    }

    @GetMapping("/auth/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        Map<String, Object> user = userService.getUser(id);
        int status = (int) user.get("statusCode");
        if (status != 200) {
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
