package com.hotel.ishimwe_hirwa.controller;

import com.hotel.ishimwe_hirwa.dto.RoomsDto;
import com.hotel.ishimwe_hirwa.model.Rooms;
import com.hotel.ishimwe_hirwa.service.RoomsService;
import com.hotel.ishimwe_hirwa.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomsController {
    private final RoomsService roomsService;

    public RoomsController (RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<ApiResponse<List<Rooms>>> getRoomsByHotelId (@RequestParam Long hotelId) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained rooms!!!", this.roomsService.getAllRoomsByHotelId(hotelId)));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Rooms>> createRooms (@RequestBody RoomsDto roomsDto) {
        Rooms room = this.roomsService.createRoom(roomsDto);
        if (room != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully created a new room!!! 🎉🎉🎉", room));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Provided wrong information please check!!! 😔😔😔", null));
    }
}
