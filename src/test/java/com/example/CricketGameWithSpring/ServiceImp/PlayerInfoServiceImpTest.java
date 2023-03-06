package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.PlayerInfoDao;
import com.example.CricketGameWithSpring.Entity.PlayerInfo;
import com.example.CricketGameWithSpring.Service.PlayerInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PlayerInfoServiceImpTest {

    @Mock
    PlayerInfoDao playerInfoDao;
    @InjectMocks
    PlayerInfoServiceImp playerInfoServiceImp;
    @Test
    void getPlayerInfoByPlayerRole() {

        playerInfoServiceImp.getPlayerInfoByPlayerRole("Bowler");
        verify(playerInfoDao).findByRole("Bowler");
    }

    @Test
    void checkPlayersInfoPresentOrNot(){

            playerInfoServiceImp.checkPlayersInfoPresentOrNot();
         verify(playerInfoDao, times(35)).save(any(PlayerInfo.class));
    }
}