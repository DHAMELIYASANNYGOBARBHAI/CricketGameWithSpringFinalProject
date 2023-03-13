package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.entity.Player;
import com.example.CricketGameWithSpring.entity.PlayerRole;
import com.example.CricketGameWithSpring.entity.Team;
import com.example.CricketGameWithSpring.service.PlayCricketMatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayCricketMatchServiceImpTest {


    @Autowired
    private PlayCricketMatchService playCricketMatchService;

    @Test
    void testPlayCricketMatchBetweenTwoTeam(){

        // create players for team 1
        List<Player> playersTeam1 = new ArrayList<>();
        playersTeam1.add(new Player(1L,"John", PlayerRole.Batsman,"India",1));
        playersTeam1.add(new Player(2L,"Mike",PlayerRole.Batsman ,"India",1));
        playersTeam1.add(new Player(3L,"Sarah", PlayerRole.AllRounder,"India",1));
        playersTeam1.add(new Player(4L,"David", PlayerRole.Bowler,"India",1));
        playersTeam1.add(new Player(5L,"Jessica", PlayerRole.Bowler, "India",1));


        // create bowlers for team 1
        List<Player> bowlersTeam1 = new ArrayList<>();
        bowlersTeam1.add(playersTeam1.get(3));
        bowlersTeam1.add(playersTeam1.get(4));

        // create players for team 2
        List<Player> playersTeam2 = new ArrayList<>();
        playersTeam2.add(new Player(1L,"Tom", PlayerRole.Batsman,"PAK",1));
        playersTeam2.add(new Player(2L,"Anna", PlayerRole.Batsman, "PAK",1));
        playersTeam2.add(new Player(3L,"Steve", PlayerRole.AllRounder, "PAK",1));
        playersTeam2.add(new Player(4L,"Samantha", PlayerRole.Bowler, "PAK",1));
        playersTeam2.add(new Player(5L,"Alex", PlayerRole.Bowler, "PAK",1));

        // create bowlers for team 2
        List<Player> bowlersTeam2 = new ArrayList<>();
        bowlersTeam2.add(playersTeam2.get(3));
        bowlersTeam2.add(playersTeam2.get(4));

        // create teams for the match
       Team team1 = new Team(1, "Team 1", playersTeam1, bowlersTeam1);
       Team team2 = new Team(1, "Team 2", playersTeam2, bowlersTeam2);


        int overs = 4;
        int score = playCricketMatchService.playCricketMatchBetweenTwoTeam(team1, team2, overs);
        assertTrue(score > 0 && score <= overs * 36, "Score is not within valid range");
    }


}