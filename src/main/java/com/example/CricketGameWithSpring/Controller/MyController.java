package com.example.CricketGameWithSpring.Controller;

import com.example.CricketGameWithSpring.Entity.*;
import com.example.CricketGameWithSpring.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class  MyController
{
    @Autowired
    private CricketService cricketService;

    @Autowired
    private ScoreBordDetailService scoreBordDetailService;

    @Autowired
    private MatchInfoService matchInfoService;

    @Autowired
    private HistoryOfMatchService historyOfMatchService;

    @Autowired
    private PlayerInfoService playerInfoService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamDetailService teamDetailService;

    @PostMapping("/startMatch")
    private List<String> startMatch(@RequestBody MatchDetails matchDetails) {

        return cricketService.startGame(matchDetails);
    }

    @GetMapping("/matchDetail/scoreBordImp/{matchId}") //ScoreBordDetail
    private ScoreBordDetail getScoreBordDetailOfMatch(@PathVariable String matchId)
    {
        return scoreBordDetailService.getScoreBordDetailOfMatch(Integer.parseInt(matchId));
    }

    @GetMapping("/matchDetail/scoreBordDetailUsingTeam/{teamName}") //ScoreBordDetail
    private List<ScoreBordDetail> getScoreBordDetailOfMatchUsingTeam(@PathVariable String teamName)
    {
        return scoreBordDetailService.getScoreBordDetailOfMatchUsingTeam(teamName);
    }

    @GetMapping("/matchDetail/matchInfo/{matchId}")
    private MatchInfo getMatchInfoOfMatch(@PathVariable String matchId)
    {
        return matchInfoService.getMatchInfoOfMatch(Integer.parseInt(matchId));
    }

    @GetMapping("/matchDetail/matchInfoUsingTeam/{teamName}")
    private List<MatchInfo> getMatchInfoOfMatchUsingTeam(@PathVariable String teamName)
    {
        return matchInfoService.getMatchInfoOfMatchUsingTeam(teamName);
    }

    @GetMapping("/matchDetail/player/{playerName}")
    private List<Player> getPlayerByPlayerName(@PathVariable String playerName)
    {
        return playerService.getPlayerByPlayerName(playerName);
    }

    @GetMapping("/matchDetail/playerInfo/{playerRole}")
    private List<PlayerInfo> getPlayerInfoByPlayerRole(@PathVariable String playerRole)
    {

        return playerInfoService.getPlayerInfoByPlayerRole(playerRole);
    }
    @GetMapping("/matchDetail/teamDetail/{teamName}")
    private List<TeamDetail> getTeamDetailByTeamName(@PathVariable String teamName)
    {

        return teamDetailService.getTeamDetailByTeamName(teamName);
    }
    @GetMapping("/historyOfMatchDetail/{matchId}")
    private HistoryOfMatch getMatchDetails(@PathVariable String matchId)
    {
        return historyOfMatchService.getMatchDetails(Integer.parseInt(matchId));
    }
    @GetMapping("/matchDetail/playerUsingElasticSearch/{playerName}")
    private List<PlayersAllDetail> getPlayerByPlayerNameUsingElasticsearch(@PathVariable String playerName)
    {
        return playerService.getPlayerByPlayerNameUsingElasticSearch(playerName);
    }


}
