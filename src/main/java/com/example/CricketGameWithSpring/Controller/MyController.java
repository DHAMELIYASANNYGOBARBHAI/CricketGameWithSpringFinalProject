package com.example.CricketGameWithSpring.Controller;

import com.example.CricketGameWithSpring.Entity.*;
import com.example.CricketGameWithSpring.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Configurable
public class  MyController
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

    @PostMapping("/startMatch")
    public List<String> startMatch(@RequestBody MatchDetails matchDetails) {

        return cricketService.startGame(matchDetails);
    }

    @GetMapping("/matchDetail/scoreBordImp/{matchId}") //ScoreBordDetail
    ScoreBordDetail getScoreBordDetailOfMatch(@PathVariable String matchId)
    {
        return scoreBordDetailService.getScoreBordDetailOfMatch(Integer.parseInt(matchId));
    }

    @GetMapping("/matchDetail/scoreBordDetailUsingTeam/{teamName}") //ScoreBordDetail
    List<ScoreBordDetail> getScoreBordDetailOfMatchUsingTeam(@PathVariable String teamName)
    {
        return scoreBordDetailService.getScoreBordDetailOfMatchUsingTeam(teamName);
    }

    @GetMapping("/matchDetail/matchInfo/{matchId}")
    MatchInfo getMatchInfoOfMatch(@PathVariable String matchId)
    {
        return matchInfoService.getMatchInfoOfMatch(Integer.parseInt(matchId));
    }

    @GetMapping("/matchDetail/matchInfoUsingTeam/{teamName}")
    List<MatchInfo> getMatchInfoOfMatchUsingTeam(@PathVariable String teamName)
    {
        return matchInfoService.getMatchInfoOfMatchUsingTeam(teamName);
    }

    @GetMapping("/matchDetail/player/{playerName}")
    List<Player> getPlayerByPlayerName(@PathVariable String playerName)
    {
        return playerService.getPlayerByPlayerName(playerName);
    }

    @GetMapping("/matchDetail/playerInfo/{playerRole}")
    List<PlayerInfo> getPlayerInfoByPlayerRole(@PathVariable String playerRole)
    {

        return playerInfoService.getPlayerInfoByPlayerRole(playerRole);
    }
    @GetMapping("/matchDetail/teamDetail/{teamName}")
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
