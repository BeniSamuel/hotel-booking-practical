package com.hotel.ishimwe_hirwa.service;

import com.hotel.ishimwe_hirwa.dto.RoomsDto;
import com.hotel.ishimwe_hirwa.model.Hotel;
import com.hotel.ishimwe_hirwa.model.Rooms;
import com.hotel.ishimwe_hirwa.repository.RoomsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsService {
    private final RoomsRepository roomsRepository;
    private final HotelService hotelService;

    public RoomsService (RoomsRepository roomsRepository, HotelService hotelService) {
        this.roomsRepository = roomsRepository;
        this.hotelService = hotelService;
    }

    public List<Rooms> getAllRoomsByHotelId (Long id) {
        Hotel hotel = this.hotelService.getHotelById(id);
        return this.roomsRepository.getAllByHotel(hotel);
    }

    public Rooms createRoom (RoomsDto roomsDto) {
        Hotel hotel = this.hotelService.getHotelById(roomsDto.getHotel_id());
        if (hotel != null) {
            Rooms newroom = new Rooms(hotel, roomsDto.getRoom_type(), roomsDto.getPrice(), roomsDto.getIsAvailable());
            return this.roomsRepository.save(newroom);
        }
        return null;
    }

    public Rooms getRoomById (Long id) {
        return this.roomsRepository.getRoomsById(id).orElse(null);
    }


}
