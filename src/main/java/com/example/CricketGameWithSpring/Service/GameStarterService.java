package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.Team;

import java.util.List;

public interface GameStarterService
{
    public List<String> start(MatchDetails matchDetails);
}
