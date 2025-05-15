package com.hotel.ishimwe_hirwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.ishimwe_hirwa.model.Hotel;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> getHotelById (Long id);
}
