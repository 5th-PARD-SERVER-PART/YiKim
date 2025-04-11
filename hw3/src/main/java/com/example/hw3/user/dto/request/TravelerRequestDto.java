package com.example.hw3.user.dto.request;

import com.example.hw3.user.dto.TravelerDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelerRequestDto {
    private long travelerId;
    private String departure;
    private String arrival;
    private String seat;
    private String travelerName;

    public TravelerDto toEntity() {
        return TravelerDto.builder()
                .departure(this.departure)
                .arrival(this.arrival)
                .seat(this.seat)
                .travelerName(this.travelerName)
                .build();
    }
}
