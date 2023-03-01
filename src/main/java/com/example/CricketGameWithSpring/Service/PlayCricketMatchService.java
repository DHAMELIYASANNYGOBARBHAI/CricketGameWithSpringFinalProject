package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PlayCricketMatchService {
    public int playCricketMatchBetweenTwoTeam(Team battingTeam,Team bowlingTeam,int Overs);
    public int randomRunOrWicketGeneratorOnEveryBall();
    public List<Player> StrikeChange(Player batsman1, Player batsman2);
}
