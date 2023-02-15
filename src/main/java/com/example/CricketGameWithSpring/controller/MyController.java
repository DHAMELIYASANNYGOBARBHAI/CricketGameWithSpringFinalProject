package com.example.CricketGameWithSpring.controller;

import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Service.CricketService;
import com.example.CricketGameWithSpring.Service.GameStarter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MyController
{
    CricketService cs = new CricketService();

    @GetMapping("/")
    String Demo()
    {
        return "Hello World";
    }

    @GetMapping("/start")
    ArrayList<String> GameStart()
    {
        return cs.GameStart();
    }

    @PostMapping("/matches")
    public ArrayList<String> startMatch(@RequestBody MatchDetails matchDetails)
    {
          return cs.GameStart(matchDetails);
    }




}
