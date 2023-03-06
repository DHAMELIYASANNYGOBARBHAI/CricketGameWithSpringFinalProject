package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Service.*;
import org.bson.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CricketServiceImpTest
{
    @Autowired
    private CricketServiceImp cricketService;

    @MockBean
    private GameStarterServiceImp gameStarterService;

    @MockBean
    private PlayerInfoService playerInfoService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void startGame()
    {

        MatchDetails matchDetails = new MatchDetails();
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("random text1");
        expectedOutput.add("random text2");
        doNothing().when(playerInfoService).checkPlayersInfoPresentOrNot();
        Mockito.when(gameStarterService.start(new MatchDetails())).thenReturn(expectedOutput);
        List<String> actualOutput = cricketService.startGame(matchDetails);
        assertEquals(expectedOutput, actualOutput);
        Mockito.verify(playerInfoService, times(1)).checkPlayersInfoPresentOrNot();
        Mockito.verify(gameStarterService, times(1)).start(matchDetails);


    }
}


