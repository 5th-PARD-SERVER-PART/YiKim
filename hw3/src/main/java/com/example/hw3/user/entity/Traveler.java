package com.example.hw3.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "traveler")
public class Traveler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long travelerId;

    @Column(nullable = false)
    private String departure;

    @Column(nullable = false)
    private String arrival;

    @Column(length = 10)
    private String seat;

    @Column(length = 30)
    private String travelerName;

    @CreationTimestamp
    private Timestamp reservationTime;

    public void update(String departure, String arrival, String seat, String travelerName) {
        this.departure = departure;
        this.arrival = arrival;
        this.seat = seat;
        this.travelerName = travelerName;
    }
}