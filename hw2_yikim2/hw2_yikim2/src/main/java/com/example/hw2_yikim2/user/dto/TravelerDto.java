package com.example.hw2_yikim2.user.dto;

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
    private long travelerID;
    private String departure;
    private String arrival;
    private String seat;
    private String travelerName;
}
