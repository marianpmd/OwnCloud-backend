package com.marian.owncloudbackend.controller;

import com.marian.owncloudbackend.DTO.UserAuthDTO;
import com.marian.owncloudbackend.DTO.UserDTO;
import com.marian.owncloudbackend.entity.UserEntity;
import com.marian.owncloudbackend.service.FileStoreService;
import com.marian.owncloudbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final FileStoreService fileStoreService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody UserAuthDTO user) {
        UserEntity userEntity = userService.registerNewUser(user.email(), user.password());
        boolean wasSuccessful = this.fileStoreService.createUserDirectory(userEntity); //todo return response accordingly
        return ResponseEntity.ok(user);
    }


}
