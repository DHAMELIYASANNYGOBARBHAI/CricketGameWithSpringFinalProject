package com.example.CricketGameWithSpring.controller;

import com.example.CricketGameWithSpring.Entity.HistoryOfCricketMatch;
import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Entity.MatchInfo;
import com.example.CricketGameWithSpring.Entity.ScoreBordDetail;
import com.example.CricketGameWithSpring.Service.CricketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Configurable
public class MyController
{
    @Autowired
    public CricketServiceImp cricketServiceImp;

    @PostMapping("/StartMatch")
    public List<String> startMatch(@RequestBody MatchDetails matchDetails) {
          return cricketServiceImp.startGame(matchDetails);
    }

    @GetMapping("/MatchDetail/{matchId}")
    HistoryOfCricketMatch getMatchDetails(@PathVariable String matchId)
    {
        return cricketServiceImp.getMatchDetails(Integer.parseInt(matchId));
    }

    @GetMapping("/MatchDetail/ScoreBordImp/{matchId}")
    ScoreBordDetail getScoreBordDetailOfMatch(@PathVariable String matchId)
    {
        return cricketServiceImp.getScoreBordDetailOfMatch(Integer.parseInt(matchId));
    }

    @GetMapping("/MatchDetail/MatchInfo/{matchId}")
    MatchInfo getMatchInfoOfMatch(@PathVariable String matchId)
    {
        return cricketServiceImp.getMatchInfoOfMatch(Integer.parseInt(matchId));
    }


}
