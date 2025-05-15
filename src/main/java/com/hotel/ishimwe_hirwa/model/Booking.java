package com.hotel.ishimwe_hirwa.model;

import com.hotel.ishimwe_hirwa.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "rooms_id")
    private Rooms rooms;

    private boolean check_in;
    private boolean check_out;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Booking () {}
    public Booking (User user, Rooms rooms, boolean check_in, boolean check_out, Status status) {
        this.user = user;
        this.rooms = rooms;
        this.check_in = check_in;
        this.check_out = check_out;
        this.status = status;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public void setRooms (Rooms rooms) {
        this.rooms = rooms;
    }

    public void setCheck_in(boolean check_in) {
        this.check_in = check_in;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCheck_out(boolean check_out) {
        this.check_out = check_out;
    }

    public void setStatus (Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public boolean isCheck_in() {
        return check_in;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isCheck_out() {
        return check_out;
    }

    public Rooms getRooms() {
        return rooms;
    }

}
