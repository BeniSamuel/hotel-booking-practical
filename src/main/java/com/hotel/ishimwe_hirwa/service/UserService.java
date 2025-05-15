package com.hotel.ishimwe_hirwa.service;

import com.hotel.ishimwe_hirwa.dto.UserRegisterDto;
import com.hotel.ishimwe_hirwa.model.User;
import com.hotel.ishimwe_hirwa.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers () {
        return this.userRepository.findAll();
    }

    public User getUserByEmail (String email) {
        return this.userRepository.getUserByEmail(email).orElse(null);
    }

    public User getUserById (Long id) {
        return this.userRepository.getUserById(id).orElse(null);
    }

    public User createUser (UserRegisterDto userRegisterDto) {
        User newUser = new User(userRegisterDto.getName(), userRegisterDto.getEmail(), passwordEncoder.encode(userRegisterDto.getPassword()), userRegisterDto.getRole());
        return this.userRepository.save(newUser);
    }

    public User updateUserById (Long id, UserRegisterDto userRegisterDto) {
        User user = this.getUserById(id);
        if (user != null) {
            user.setName(userRegisterDto.getName());
            user.setEmail(userRegisterDto.getEmail());
            user.setPassword(userRegisterDto.getPassword());
            user.setRole(userRegisterDto.getRole());

            return this.userRepository.save(user);
        }

        return null;
    }

    public boolean deleteUserById (Long id) {
        User user = this.getUserById(id);
        if (user != null) {
            this.userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
