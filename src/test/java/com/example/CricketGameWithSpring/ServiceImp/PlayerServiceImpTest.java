package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.PlayerDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PlayerServiceImpTest {

    @InjectMocks
    PlayerServiceImp playerServiceImp;

    @Mock
    PlayerDao playerDao;

    @Test
    void getPlayerByPlayerName(){

        playerServiceImp.getPlayerByPlayerName("sachin");
        verify(playerDao).findByName("sachin");
    }
}