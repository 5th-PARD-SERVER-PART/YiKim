package com.example.hw3.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelerDto {
    private long travelerId;
    private String departure;
    private String arrival;
    private String seat;
    private String travelerName;
}
