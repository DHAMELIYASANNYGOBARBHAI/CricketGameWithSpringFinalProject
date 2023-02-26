package com.example.CricketGameWithSpring.controller;

import com.example.CricketGameWithSpring.Entity.*;
import com.example.CricketGameWithSpring.Service.CricketService;
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
    public CricketService cricketService;

    @PostMapping("/StartMatch")
    public List<String> startMatch(@RequestBody MatchDetails matchDetails) {
          return cricketService.startGame(matchDetails);
    }

    @GetMapping("/MatchDetail/ScoreBordImp/{matchId}") //ScoreBordDetail
    ScoreBordDetail getScoreBordDetailOfMatch(@PathVariable String matchId)
    {
        return cricketService.getScoreBordDetailOfMatch(Integer.parseInt(matchId));
    }

    @GetMapping("/MatchDetail/ScoreBordDetailUsingTeam/{teamName}") //ScoreBordDetail
    List<ScoreBordDetail> getScoreBordDetailOfMatchUsingTeam(@PathVariable String teamName)
    {
        return cricketService.getScoreBordDetailOfMatchUsingTeam(teamName);
    }

    @GetMapping("/MatchDetail/MatchInfo/{matchId}")
    MatchInfo getMatchInfoOfMatch(@PathVariable String matchId)
    {
        return cricketService.getMatchInfoOfMatch(Integer.parseInt(matchId));
    }

    @GetMapping("/MatchDetail/MatchInfoUsingTeam/{teamName}")
    List<MatchInfo> getMatchInfoOfMatchUsingTeam(@PathVariable String teamName)
    {
        return cricketService.getMatchInfoOfMatchUsingTeam(teamName);
    }

    @GetMapping("/MatchDetail/Player/{playerName}")
    List<Player> getPlayerByPlayerName(@PathVariable String playerName)
    {

        return cricketService.getPlayerByPlayerName(playerName);
    }

    @GetMapping("/MatchDetail/PlayerInfo/{playerRole}")
    List<PlayerInfo> getPlayerInfoByPlayerRole(@PathVariable String playerRole)
    {

        return cricketService.getPlayerInfoByPlayerName(playerRole);
    }
    @GetMapping("/MatchDetail/TeamDetail/{teamName}")
    List<TeamDetail> getTeamDetailByTeamName(@PathVariable String teamName)
    {

        return cricketService.getTeamDetailByTeamName(teamName);
    }
    @GetMapping("/historyOfMatchDetail/{matchId}")
    HistoryOfMatch getMatchDetails(@PathVariable String matchId)
    {
        return cricketService.getMatchDetails(Integer.parseInt(matchId));
    }




}
