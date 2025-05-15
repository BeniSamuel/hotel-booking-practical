package com.hotel.ishimwe_hirwa.controller;

import com.hotel.ishimwe_hirwa.model.User;
import com.hotel.ishimwe_hirwa.service.UserService;
import com.hotel.ishimwe_hirwa.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotel/v1/users")
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers () {
        return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained users!!! 🎉🎉🎉", this.userService.getAllUsers()));
    }
}
