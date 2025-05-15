package com.hotel.ishimwe_hirwa.dto;

import com.hotel.ishimwe_hirwa.enums.Status;

public class BookingDto {
    private Long user_id;
    private Long room_id;
    private boolean check_in;
    private boolean check_out;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public boolean isCheck_out() {
        return check_out;
    }

    public boolean isCheck_in() {
        return check_in;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public Long getUser_id() {
        return user_id;
    }
}
