package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.PlayerDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

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