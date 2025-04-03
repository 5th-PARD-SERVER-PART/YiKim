package com.example.hw2_yikim2.user.service;

import com.example.hw2_yikim2.user.dto.TravelerDto;
import com.example.hw2_yikim2.user.entity.Traveler;
import com.example.hw2_yikim2.user.repository.TravelerRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TravelerService {
    private final TravelerRepository travelerRepository;

    public void create(TravelerDto userDto){
        travelerRepository.createReservation(userDto);
    }

    public TravelerDto getReservationByID(Long studentID){
        return travelerRepository.getReservation(studentID);
    }

    public void update(Long studentID, TravelerDto userDto){
        travelerRepository.updateReservation(studentID, userDto);
    }

    public void deleteReservationByID(Long studentID){
        travelerRepository.deleteReservation(studentID);
    }

    public Collection<Traveler> getAllReservationByID(){
        return travelerRepository.getAllReservations();
    }
}
