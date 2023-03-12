package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.MatchInfoDao;
import com.example.CricketGameWithSpring.dao.PlayerInfoDao;
import com.example.CricketGameWithSpring.entity.MatchDetails;
import com.example.CricketGameWithSpring.service.MatchService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GameStarterServiceImpTest {


    @Autowired
    private MatchService matchService;

    @InjectMocks
    GameStarterServiceImp gameStarterServiceImp;

    @MockBean
    private MatchInfoDao matchInfoDao;
    @MockBean
    private PlayerInfoDao playerInfoDao;
    @MockBean
    private MatchServiceImp matchServiceImp;



    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void start() {

        MatchDetails matchDetails = new MatchDetails();
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("random text1");
        expectedOutput.add("random text2");
        Mockito.when(matchService.startGame()).thenReturn(expectedOutput);
        List<String> actualOutput = matchService.startGame();
        assertEquals(expectedOutput, actualOutput);
        Mockito.verify(matchService, times(1)).startGame();

    }

    @Test
    void getCurrentMatchId() {

        gameStarterServiceImp.getCurrentMatchId();
      verify(matchInfoDao).findFirstByOrderByIdDesc();

      
    }

}