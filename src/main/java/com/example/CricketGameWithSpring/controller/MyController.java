package com.example.CricketGameWithSpring.controller;

import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Service.CricketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@Configurable
public class MyController{
    @Autowired
    public CricketService cricketService;
    @PostMapping("/matches")
    public ArrayList<String> startMatch(@RequestBody MatchDetails matchDetails) {
          return cricketService.startGame(matchDetails);
    }

}
