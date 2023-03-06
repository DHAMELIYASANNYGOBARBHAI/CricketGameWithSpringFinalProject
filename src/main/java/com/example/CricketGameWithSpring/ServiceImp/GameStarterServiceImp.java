package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.*;
import com.example.CricketGameWithSpring.Entity.*;
import com.example.CricketGameWithSpring.Exception.InputValidationException;
import com.example.CricketGameWithSpring.Service.GameStarterService;
import com.example.CricketGameWithSpring.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameStarterServiceImp implements GameStarterService
{

    @Autowired
    private MatchInfoDao matchInfoDao;
    @Autowired
    private PlayerInfoDao playerInfoDao;
    @Autowired
    private MatchService matchService;
    @Autowired
    private MatchServiceImp matchServiceImp;


    @Override
    public List<String> start(MatchDetails matchDetails)
    {
        matchServiceImp.setMatchId(this.getCurrentMatchId());
        matchServiceImp.setTeam1(getTeam(matchDetails.getTeam1Name(),matchDetails.getTeam1PlayerId()));
        matchServiceImp.setTeam2(getTeam(matchDetails.getTeam2Name(),matchDetails.getTeam2PlayerId()));
        matchServiceImp.setOvers(matchDetails.getOvers());
        return matchService.startGame();
    }

    public int getCurrentMatchId(){
        MatchInfo lastDocument = matchInfoDao.findFirstByOrderByIdDesc().orElse(null);
        if(lastDocument==null) return 1;
        else return lastDocument.getId()+1;
    }
    @Override
    public Team getTeam(String teamName, List<Integer> teamPlayerId){
        List<Player> players = getPlayersOfTeam(teamName,teamPlayerId);
        Team team = new Team();
        team.setMatchId(matchServiceImp.getMatchId());
        team.setTeamName(teamName);
        team.setPlayersOfTeam(players);
        team.setBowlersInTeam(team.getBowlerOrAllRounderInTeam());
        for(Player player : players) player.setTeamName(teamName);
        return team;
    }
    @Override
    public List<Player> getPlayersOfTeam(String teamName,List<Integer> teamPlayerId){
        List<Player>  playersOfTeam = new ArrayList<Player>();
        for(int id : teamPlayerId){
            int is_valid  = playerInfoDao.countById(id);
            if(is_valid > 0){
                Player player = new Player();
                player.setPlayerName(playerInfoDao.findNameById(id));
                player.setPlayerRole(playerInfoDao.findRoleById(id));
                playersOfTeam.add(player);
            }
            else {throw new InputValidationException("I'm sorry, it appears that the input ID provided is not valid in " +teamName+ " Team.Please provide a valid input ID from the PlayerInfo table. Thank you.");}
        }
        return playersOfTeam;
    }


}
