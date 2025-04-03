package com.example.hw2_yikim2.user.repository;

import com.example.hw2_yikim2.user.dto.TravelerDto;
import com.example.hw2_yikim2.user.entity.Traveler;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class TravelerRepository {
    private static final Map<Long, Traveler> reservation = new HashMap<>();

    public void createReservation(TravelerDto travelerDto){
        Traveler traveler = Traveler.builder()
                .travelerID(travelerDto.getTravelerID())
                .departure(travelerDto.getDeparture())
                .arrival(travelerDto.getArrival())
                .travelerName(travelerDto.getTravelerName())
                .seat(travelerDto.getSeat())
                .build();
        reservation.put(travelerDto.getTravelerID(), traveler);
    }

    public TravelerDto getReservation(Long travelerID){
        Traveler traveler = reservation.get(travelerID);
        if(traveler == null){
            throw new IllegalArgumentException("해당 id로 된 예약이 존재하지 않습니다.");
        }

        return TravelerDto.builder()
                .travelerID(traveler.getTravelerID())
                .departure(traveler.getDeparture())
                .arrival(traveler.getArrival())
                .travelerName(traveler.getTravelerName())
                .seat(traveler.getSeat())
                .build();
    }

    public void updateReservation(Long travelerID, TravelerDto travelerDto){
        Traveler traveler = reservation.get(travelerID);
        if(traveler == null){
            throw new IllegalArgumentException("해당 id로 된 예약이 존재하지 않습니다.");
        }

        traveler.setDeparture(travelerDto.getDeparture());
        traveler.setArrival(travelerDto.getArrival());
        traveler.setTravelerName(travelerDto.getTravelerName());
        traveler.setSeat(travelerDto.getSeat());
        reservation.put(travelerID, traveler);
    }

    public void deleteReservation(Long travelerID){
        if(!reservation.containsKey(travelerID)){
            throw new IllegalArgumentException("해당 id로 된 예약이 존재하지 않습니다.");
        }
        reservation.remove(travelerID);
    }

    public Collection<Traveler> getAllReservations() {
        return reservation.values();
    }
}
