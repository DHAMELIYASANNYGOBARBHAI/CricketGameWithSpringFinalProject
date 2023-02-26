package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.*;

import java.util.List;

public interface CricketService
{
    public List<String> startGame(MatchDetails matchDetails);
    public HistoryOfMatch getMatchDetails(int matchId);
    public ScoreBordDetail getScoreBordDetailOfMatch(int matchId);
    public MatchInfo getMatchInfoOfMatch(int matchId);
    public List<Player> getPlayerByPlayerName(String playerName);
    public List<PlayerInfo> getPlayerInfoByPlayerName(String playerRole);
    public List<TeamDetail> getTeamDetailByTeamName(String teamName);
    public List<ScoreBordDetail> getScoreBordDetailOfMatchUsingTeam(String teamName);
    public List<MatchInfo> getMatchInfoOfMatchUsingTeam(String teamName);
}
