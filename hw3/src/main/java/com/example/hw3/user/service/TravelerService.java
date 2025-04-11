package com.example.hw3.user.service;

import com.example.hw3.user.dto.TravelerDto;
import com.example.hw3.user.entity.Traveler;
import com.example.hw3.user.repo.TravelerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TravelerService {
    private final TravelerRepo travelerRepo;

    public void create(TravelerDto dto) {
        Traveler traveler = Traveler.builder()
                .departure(dto.getDeparture())
                .arrival(dto.getArrival())
                .seat(dto.getSeat())
                .travelerName(dto.getTravelerName())
                .build();
        travelerRepo.save(traveler);
    }

    public TravelerDto getReservationById(Long id) {
        Traveler t = travelerRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 예약이 존재하지 않습니다."));
        return toDto(t);
    }

    public void update(Long id, TravelerDto dto) {
        Traveler t = travelerRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수정할 예약을 찾을 수 없습니다."));
        t.update(dto.getDeparture(), dto.getArrival(), dto.getSeat(), dto.getTravelerName());
        travelerRepo.save(t);
    }

    public void delete(Long id) {
        travelerRepo.deleteById(id);
    }

    public TravelerDto findByTravelerName(String name) {
        Traveler traveler = travelerRepo.findByTravelerName(name);
        if (traveler == null) throw new IllegalArgumentException("해당 이름의 예약자가 없습니다.");
        return toDto(traveler);
    }

    public List<TravelerDto> findAllByDeparture(String departure) {
        return travelerRepo.findAllByDeparture(departure).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public boolean isSeatReserved(String arrival, String seat) {
        return travelerRepo.existsByArrivalAndSeat(arrival, seat);
    }


    private TravelerDto toDto(Traveler t) {
        return TravelerDto.builder()
                .travelerId(t.getTravelerId())
                .departure(t.getDeparture())
                .arrival(t.getArrival())
                .seat(t.getSeat())
                .travelerName(t.getTravelerName())
                .build();
    }

}
