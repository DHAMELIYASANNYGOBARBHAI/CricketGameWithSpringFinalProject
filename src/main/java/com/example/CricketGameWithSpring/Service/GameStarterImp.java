package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Dao.*;
import com.example.CricketGameWithSpring.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameStarterImp implements GameStarter
{
    @Autowired
    public PlayerInfoDao playerInfoDao;
    @Autowired
    MatchImp matchImp;

    public List<String> start(MatchDetails matchDetails)
    {
        matchImp.setTeam1(getTeam(matchDetails.getTeam1Name(),matchDetails.getTeam1PlayerId()));
        matchImp.setTeam2(getTeam(matchDetails.getTeam2Name(),matchDetails.getTeam2PlayerId()));
        matchImp.setOvers(matchDetails.getOvers());

        return matchImp.startGame();
    }
    public Team getTeam(String teamName, List<Integer> teamPlayerId)
    {
        List<Player> players = getPlayersOfTeam(teamPlayerId);
        Team team = new Team(teamName, (ArrayList<Player>) players);
        for(Player player : players) player.setTeamName(teamName);
        return team;
    }

   public List<Player> getPlayersOfTeam(List<Integer> teamPlayerId)
    {
        List<Player>  playersOfTeam = new ArrayList<Player>();
        for(int id : teamPlayerId)
        {
            int is_valid  = playerInfoDao.countById(id);
            if(is_valid > 0)
            {
                playersOfTeam.add(new Player(playerInfoDao.findNameById(id), playerInfoDao.findRoleById(id)));
            }
            else {
                // do something
                throw new IllegalArgumentException("Invalid player ID: " + id);
            }
        }

         return playersOfTeam;
    }

}
