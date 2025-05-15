package com.hotel.ishimwe_hirwa.repository;

import com.hotel.ishimwe_hirwa.model.Hotel;
import com.hotel.ishimwe_hirwa.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomsRepository extends JpaRepository<Rooms, Long> {
    Optional<Rooms> getRoomsById (Long id);
    List<Rooms> getAllByHotel (Hotel hotel);
}
