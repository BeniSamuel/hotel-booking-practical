package com.hotel.ishimwe_hirwa.security;

import com.hotel.ishimwe_hirwa.exception.NotFoundException;
import com.hotel.ishimwe_hirwa.repository.UserRepository;
import com.hotel.ishimwe_hirwa.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getUserByEmail(username).orElseThrow(() -> new NotFoundException("User not found!!!"));
        return new CustomUserDetails(user);
    }
}

