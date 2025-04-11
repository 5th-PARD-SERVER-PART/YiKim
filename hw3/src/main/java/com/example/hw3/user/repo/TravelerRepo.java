package com.example.hw3.user.repo;

import com.example.hw3.user.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelerRepo extends JpaRepository<Traveler, Long> {
    Traveler findByTravelerName(String travelerName);
    List<Traveler> findAllByDeparture(String departure);
    boolean existsByArrivalAndSeat(String arrival, String seat);
}
