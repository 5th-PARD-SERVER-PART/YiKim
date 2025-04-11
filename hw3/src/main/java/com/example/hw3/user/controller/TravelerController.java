package com.example.hw3.user.controller;

import com.example.hw3.user.dto.TravelerDto;
import com.example.hw3.user.service.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class TravelerController {
    private final TravelerService travelerService;

    @PostMapping("")
    public String save(@RequestBody TravelerDto travelerDto){
        travelerService.create(travelerDto);
        return travelerDto.getTravelerName() + "님의 예매가 완료되었습니다.";
    }

    @GetMapping("/{travelerID}")
    public TravelerDto findByID(@PathVariable Long travelerID){
        return travelerService.getReservationById(travelerID);
    }

    @PatchMapping("/{travelerID}")
    public String updateByID(@PathVariable Long travelerID, @RequestBody TravelerDto travelerDto){
        travelerService.update(travelerID, travelerDto);
        return travelerDto.getTravelerName() + "님의 예매가 수정되었습니다.";
    }

    @DeleteMapping("/{travelerID}")
    public String delete(@PathVariable Long travelerID){
        travelerService.delete(travelerID);
        return "해당 고객의 예매가 삭제되었습니다.";
    }

    @GetMapping("name/{name}")
    public TravelerDto findByName(@PathVariable String name) {
        return travelerService.findByTravelerName(name);
    }

}