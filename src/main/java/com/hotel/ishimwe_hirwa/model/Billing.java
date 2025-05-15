package com.hotel.ishimwe_hirwa.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private Double amount;
    private LocalDateTime generated_at;

    public Long getId() {
        return id;
    }

    public Booking getBooking() {
        return booking;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getGenerated_at() {
        return generated_at;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setGenerated_at(LocalDateTime generated_at) {
        this.generated_at = generated_at;
    }
}
