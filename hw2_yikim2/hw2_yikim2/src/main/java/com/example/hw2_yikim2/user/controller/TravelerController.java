package com.example.hw2_yikim2.user.controller;

import com.example.hw2_yikim2.user.dto.TravelerDto;
import com.example.hw2_yikim2.user.entity.Traveler;
import com.example.hw2_yikim2.user.service.TravelerService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return travelerService.getReservationByID(travelerID);
    }

    @PatchMapping("/{travelerID}")
    public String updateByID(@PathVariable Long travelerID, @RequestBody TravelerDto travelerDto){
        travelerService.update(travelerID, travelerDto);
        return travelerDto.getTravelerName() + "님의 예매가 수정되었습니다.";
    }

    @DeleteMapping("/{travelerID}")
    public String delete(@PathVariable Long travelerID){
        travelerService.deleteReservationByID(travelerID);
        return "해당 고객의 예매가 삭제되었습니다.";
    }

    @GetMapping("")
    public Collection<Traveler> findAll(){
        return travelerService.getAllReservationByID();
    }
}
