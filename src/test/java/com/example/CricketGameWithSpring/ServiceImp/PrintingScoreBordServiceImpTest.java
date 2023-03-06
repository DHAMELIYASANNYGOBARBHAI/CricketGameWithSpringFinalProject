package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Entity.Team;
import com.example.CricketGameWithSpring.Service.ScoreBordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PrintingScoreBordServiceImpTest {


    @InjectMocks
    PrintingScoreBordServiceImp printingScoreBordServiceImp;

    @Mock
    ScoreBordService scoreBordService;

    @Autowired
    MatchServiceImp matchServiceImp;

    @BeforeEach
    void setUp() {
        matchServiceImp.setScoreBordService(scoreBordService);
    }



    @Test
    void printCricketMatchScoreBordBetweenTwoTeams()
    {

        Team team1 = new Team();
        Team team2 = new Team();

        // remove this line
        // System.out.println(scoreBordService);

        // matchServiceImp.setScoreBordService(scoreBordService);
        matchServiceImp.setTeam1(team1);
        matchServiceImp.setTeam2(team2);

        System.out.println(matchServiceImp);

        // modify these lines to use the injected mock instance
        when(matchServiceImp.getScoreBordService().printScoreBordOfBattingTeam(any(Team.class))).thenReturn(Arrays.asList("Team Batting Details"));
        when(matchServiceImp.getScoreBordService().printScoreBordOfBowlingTeam(any(Team.class))).thenReturn(Arrays.asList("Team Bowling Details"));
        when(matchServiceImp.getScoreBordService().getDetailOfBall(any(Team.class))).thenReturn(Arrays.asList("Inning Ball Details"));

        // Exercise
        List<String> scoreBoardInformation = printingScoreBordServiceImp.printCricketMatchScoreBordBetweenTwoTeams(matchServiceImp);

        System.out.println(scoreBoardInformation);

        // Verify
        assertEquals(6, scoreBoardInformation.size());
        assertEquals("Team Batting Details", scoreBoardInformation.get(0));
        assertEquals("Team Bowling Details", scoreBoardInformation.get(1));
        assertEquals("Inning Ball Details", scoreBoardInformation.get(2));
        assertEquals("Team Batting Details", scoreBoardInformation.get(3));
        assertEquals("Team Bowling Details", scoreBoardInformation.get(4));
        assertEquals("Inning Ball Details", scoreBoardInformation.get(5));

    }

}