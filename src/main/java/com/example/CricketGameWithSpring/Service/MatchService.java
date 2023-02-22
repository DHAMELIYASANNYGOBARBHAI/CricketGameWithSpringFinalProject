package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.*;

import java.util.ArrayList;
import java.util.List;

public interface MatchService
{
    public List<String> startGame();
    public int toss();
    public int playGame(Team team1,Team team2) ;
    public int RandomFunction();

    public List<Player> StrikeChange(Player batsman1, Player batsman2);
    public List<String> printScoreBord(Team team1, Team team2);
}
