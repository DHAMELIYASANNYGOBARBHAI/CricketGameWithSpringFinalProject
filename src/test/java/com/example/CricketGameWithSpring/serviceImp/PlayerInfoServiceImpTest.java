package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.PlayerInfoDao;
import com.example.CricketGameWithSpring.entity.PlayerInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.any;

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
         verify(playerInfoDao, times(40)).save(any(PlayerInfo.class));
    }
}