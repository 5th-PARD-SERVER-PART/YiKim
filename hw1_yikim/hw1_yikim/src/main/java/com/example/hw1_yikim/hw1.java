package com.example.hw1_yikim;

import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hw1")
public class hw1 {

    @GetMapping("/{word}")
    public String getFoodName(@PathVariable String word){
        return "저녁 메뉴 추천 : " + word;
    }

    //문자열로 받기 때문에 클라이언트가 보낸 json데이터가 그대로 출력됨
    @PostMapping("/food-choice")
    public String recommendFoodName(@RequestBody String word){
        return "오늘의 메뉴 추천 : " + word;
    }

    @PostMapping("/food-choice2")
    public String recommendFoodName2(@RequestBody hw1_1 word){
        return "오늘의 메뉴 추천 : " + word.getWord();
    }

    @PatchMapping("/food-change/{word}")
    public String changeFoodName(@PathVariable String word){
        if(Objects.equals(word, "pizza"))
            return "patch food name : " + word;
        return "no change";
    }
}
