package com.hotel.ishimwe_hirwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.ishimwe_hirwa.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserById (Long id);
    Optional<User> getUserByEmail (String email);
}
