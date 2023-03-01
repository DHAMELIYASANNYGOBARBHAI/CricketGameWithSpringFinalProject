package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.Team;

import java.util.List;

public interface ScoreBordService
{
    public List<String> printScoreBordOfBattingTeam(Team team);
    public List<String> printScoreBordOfBowlingTeam(Team team);
    public List<String> getDetailOfBall(Team team);
    public List<String> printMatchResult(Team team1, Team team2, int team1Score, int team2Score, int overs);


}
