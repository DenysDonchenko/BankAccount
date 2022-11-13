package com.bank.api.controller;

import com.bank.api.dto.user.UserShot;
import com.bank.api.entity.User;
import com.bank.api.facade.UserFacade;
import com.bank.api.utils.validation.Uuid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<User>> getUsers() {
        return ResponseEntity.ok()
                .body( userFacade.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") @Uuid UUID userId){

        return ResponseEntity.ok()
                .body( userFacade.findById(userId));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") @Uuid UUID userId,@RequestBody UserShot request){

        return ResponseEntity.ok()
                .body( userFacade.update(request, userId));
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserShot request){

        return ResponseEntity.ok()
                .body( userFacade.create(request));
    }

}