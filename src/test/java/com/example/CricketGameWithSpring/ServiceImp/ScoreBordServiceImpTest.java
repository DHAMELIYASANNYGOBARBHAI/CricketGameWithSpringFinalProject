package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Entity.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreBordServiceImpTest {


    @InjectMocks
    private ScoreBordServiceImp scoreBordServiceImp;

    Team team;

   @BeforeEach
   void fun()
   {
      team = new Team();
   }

    @Test
    void testPrintScoreBordOfBattingTeam() {
        List<String> tableRows = scoreBordServiceImp.printScoreBordOfBattingTeam(team);
        System.out.println(tableRows);
        assertNotNull(tableRows);
        assertEquals(8, tableRows.size());
        // Assert other details of the tableRows list
    }

    @Test
    void testPrintScoreBordOfBowlingTeam() {
        List<String> tableRows = scoreBordServiceImp.printScoreBordOfBowlingTeam(team);
        assertNotNull(tableRows);
        assertEquals(7, tableRows.size());
        // Assert other details of the tableRows list
    }

    @Test
    void testGetDetailOfBall() {
        List<String> tableRows = scoreBordServiceImp.getDetailOfBall(team);
        assertNotNull(tableRows);
        assertEquals(7, tableRows.size());
        // Assert other details of the tableRows list
    }

    @Test
    @DisplayName("Print match result")
    void testPrintMatchResult() {
        Team team2 = new Team();
        int team1Score = 100;
        int team2Score = 80;
        int overs = 20;
        List<String> result = scoreBordServiceImp.printMatchResult(team, team2, team1Score, team2Score, overs);
        assertNotNull(result);
        assertEquals(10, result.size());
        // Assert other details of the result list
    }

}







