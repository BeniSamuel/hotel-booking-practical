package com.hotel.ishimwe_hirwa.service;

import com.hotel.ishimwe_hirwa.dto.UserLoginDto;
import com.hotel.ishimwe_hirwa.dto.UserRegisterDto;
import com.hotel.ishimwe_hirwa.model.User;
import com.hotel.ishimwe_hirwa.utils.ApiResponse;
import com.hotel.ishimwe_hirwa.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthService (UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public User registerUser(UserRegisterDto userRegisterDto) {
        return this.userService.createUser(userRegisterDto);
    }

    public ResponseEntity<ApiResponse<String>> loginUser (UserLoginDto userLoginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword())
            );

            User user = this.userService.getUserByEmail(userLoginDto.getEmail());
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully logged in user!!! 🎉🎉🎉", this.jwtUtil.generateToken(user.getEmail())));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Provided bad credentials!!!", null));
        }
    }
}
