package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.Team;

import java.util.List;

public interface GameStarterService
{
    public List<String> start(MatchDetails matchDetails);
    public Team getTeam(String teamName, List<Integer> teamPlayerId);
    public List<Player> getPlayersOfTeam(List<Integer> teamPlayerId);


}
