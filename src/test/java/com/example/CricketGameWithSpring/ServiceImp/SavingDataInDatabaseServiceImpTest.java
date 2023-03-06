package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.*;
import com.example.CricketGameWithSpring.Entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SavingDataInDatabaseServiceImpTest {

    @Autowired
    private MatchServiceImp matchServiceImp;

    @InjectMocks
    private SavingDataInDatabaseServiceImp savingDataInDatabaseServiceImp;

    @Mock
    public ScoreBordDetailsDao scoreBordDetailsDao;
    @Mock
    public PlayerDao playerDao;
    @Mock
    public TeamDetailDao teamDetailDao;
    @Mock
    public MatchInfoDao matchInfoDao;
    @Mock
    public HistoryOfMatchDao historyOfCricketMatchDao;

    @Test
    void savingCricketMatchRelatedDataInDatabase() {



        List<Player> playersTeam1 = new ArrayList<>();
        playersTeam1.add(new Player(1L,"John", "Batsman","India",1));
        playersTeam1.add(new Player(2L,"Mike", "Batsman","India",1));
        playersTeam1.add(new Player(3L,"Sarah", "All-rounder","India",1));
        playersTeam1.add(new Player(4L,"David", "Bowler","India",1));
        playersTeam1.add(new Player(5L,"Jessica", "Bowler", "India",1));

        // create bowlers for team 1
        List<Player> bowlersTeam1 = new ArrayList<>();
        bowlersTeam1.add(playersTeam1.get(3));
        bowlersTeam1.add(playersTeam1.get(4));

        // create players for team 2
        List<Player> playersTeam2 = new ArrayList<>();
        playersTeam2.add(new Player(1L,"Tom", "Batsman","PAK",1));
        playersTeam2.add(new Player(2L,"Anna", "Batsman", "PAK",1));
        playersTeam2.add(new Player(3L,"Steve", "All-rounder", "PAK",1));
        playersTeam2.add(new Player(4L,"Samantha", "Bowler", "PAK",1));
        playersTeam2.add(new Player(5L,"Alex", "Bowler", "PAK",1));

        // create bowlers for team 2
        List<Player> bowlersTeam2 = new ArrayList<>();
        bowlersTeam2.add(playersTeam2.get(3));
        bowlersTeam2.add(playersTeam2.get(4));

        // create teams for the match
        Team team1 = new Team(1, "Team 1", playersTeam1, bowlersTeam1);
        Team team2 = new Team(1, "Team 2", playersTeam2, bowlersTeam2);

        matchServiceImp.setMatchId(1);
        matchServiceImp.setTeam1(team1);
        matchServiceImp.setTeam2(team2);

        savingDataInDatabaseServiceImp.savingCricketMatchRelatedDataInDatabase(matchServiceImp);

       verify(playerDao, times(matchServiceImp.getTeam1().getPlayersOfTeam().size()*2)).save(any(Player.class));
       verify(teamDetailDao,times(2)).save(any(TeamDetail.class));
       verify(scoreBordDetailsDao).save(new ScoreBordDetail(matchServiceImp));
       verify(matchInfoDao).save(new MatchInfo(matchServiceImp));
       verify(historyOfCricketMatchDao).save(new HistoryOfMatch(matchServiceImp));


    }
}