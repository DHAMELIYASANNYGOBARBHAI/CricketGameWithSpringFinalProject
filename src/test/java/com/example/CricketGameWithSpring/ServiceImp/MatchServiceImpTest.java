package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.Team;
import com.example.CricketGameWithSpring.Service.PlayCricketMatchService;
import com.example.CricketGameWithSpring.Service.PrintingScoreBordService;
import com.example.CricketGameWithSpring.Service.SavingDataInDatabaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MatchServiceImpTest {

    @Mock
    PlayCricketMatchService playCricketMatchService;

    @Mock
    PrintingScoreBordService printingScoreBordService;

    @Mock
    SavingDataInDatabaseService savingDataInDatabaseService;

    @InjectMocks
    MatchServiceImp matchServiceImp;

    @Test
    void startGame()
    {

    }
}