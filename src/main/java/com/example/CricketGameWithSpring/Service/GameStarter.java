package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Dao.PlayerInfoDao;
import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public interface GameStarter
{
    public List<String> start(MatchDetails matchDetails);
    public Team getTeam(String teamName, List<Integer> teamPlayerId);
    public List<Player> getPlayersOfTeam(List<Integer> teamPlayerId);


}
