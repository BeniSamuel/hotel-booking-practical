package com.hotel.ishimwe_hirwa.controller;

import com.hotel.ishimwe_hirwa.dto.UserLoginDto;
import com.hotel.ishimwe_hirwa.dto.UserRegisterDto;
import com.hotel.ishimwe_hirwa.model.User;
import com.hotel.ishimwe_hirwa.service.AuthService;
import com.hotel.ishimwe_hirwa.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hotel/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController (AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<User>> registerUser (@RequestBody UserRegisterDto userRegisterDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully registered user!!!", this.authService.registerUser(userRegisterDto)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> loginUser (@RequestBody UserLoginDto userLoginDto) {
        return this.authService.loginUser(userLoginDto);
    }
}
