package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.MatchInfoDao;
import com.example.CricketGameWithSpring.Entity.MatchInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MatchInfoServiceImpTest {


    @Mock  // @MockBean
    MatchInfoDao matchInfoDao;
    @InjectMocks
    MatchInfoServiceImp matchInfoServiceImp;

    @Test
    void getMatchInfoOfMatchUsingTeam() {
        List<MatchInfo> matchInfos =  matchInfoServiceImp.getMatchInfoOfMatchUsingTeam("RR");
        List<MatchInfo> matchInfos1 = verify(matchInfoDao).findMatchInfoOfMatchUsingTeam("RR");
    }


    @Test
    void getMatchInfoOfMatch()
    {
        matchInfoServiceImp.getMatchInfoOfMatch(1);
        verify(matchInfoDao).findById(1);

    }
}