package com.example.CricketGameWithSpring.controller;

import com.example.CricketGameWithSpring.Entity.*;
import com.example.CricketGameWithSpring.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Configurable
public class MyController
{
    @Autowired
    public CricketService cricketService;

    @Autowired
    public ScoreBordDetailService scoreBordDetailService;

    @Autowired
    public MatchInfoService matchInfoService;

    @Autowired
    HistoryOfMatchService historyOfMatchService;

    @Autowired
    PlayerInfoService playerInfoService;

    @Autowired
    PlayerService playerService;

    @Autowired
    TeamDetailService teamDetailService;

    @PostMapping("/StartMatch")
    public List<String> startMatch(@RequestBody MatchDetails matchDetails) {
        playerInfoService.cheakPlayerInfoTableIspresentOrNot();
        return cricketService.startGame(matchDetails);
    }

    @GetMapping("/MatchDetail/ScoreBordImp/{matchId}") //ScoreBordDetail
    ScoreBordDetail getScoreBordDetailOfMatch(@PathVariable String matchId)
    {
        return scoreBordDetailService.getScoreBordDetailOfMatch(Integer.parseInt(matchId));
    }

    @GetMapping("/MatchDetail/ScoreBordDetailUsingTeam/{teamName}") //ScoreBordDetail
    List<ScoreBordDetail> getScoreBordDetailOfMatchUsingTeam(@PathVariable String teamName)
    {
        return scoreBordDetailService.getScoreBordDetailOfMatchUsingTeam(teamName);
    }

    @GetMapping("/MatchDetail/MatchInfo/{matchId}")
    MatchInfo getMatchInfoOfMatch(@PathVariable String matchId)
    {
        return matchInfoService.getMatchInfoOfMatch(Integer.parseInt(matchId));
    }

    @GetMapping("/MatchDetail/MatchInfoUsingTeam/{teamName}")
    List<MatchInfo> getMatchInfoOfMatchUsingTeam(@PathVariable String teamName)
    {
        return matchInfoService.getMatchInfoOfMatchUsingTeam(teamName);
    }

    @GetMapping("/MatchDetail/Player/{playerName}")
    List<Player> getPlayerByPlayerName(@PathVariable String playerName)
    {
        return playerService.getPlayerByPlayerName(playerName);
    }

    @GetMapping("/MatchDetail/PlayerInfo/{playerRole}")
    List<PlayerInfo> getPlayerInfoByPlayerRole(@PathVariable String playerRole)
    {

        return playerInfoService.getPlayerInfoByPlayerName(playerRole);
    }
    @GetMapping("/MatchDetail/TeamDetail/{teamName}")
    List<TeamDetail> getTeamDetailByTeamName(@PathVariable String teamName)
    {

        return teamDetailService.getTeamDetailByTeamName(teamName);
    }
    @GetMapping("/historyOfMatchDetail/{matchId}")
    HistoryOfMatch getMatchDetails(@PathVariable String matchId)
    {
        return historyOfMatchService.getMatchDetails(Integer.parseInt(matchId));
    }







}
