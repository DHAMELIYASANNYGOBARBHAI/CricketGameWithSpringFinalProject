package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.ScoreBordDetailsDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ScoreBordDetailServiceImpTest {


    @InjectMocks
    ScoreBordDetailServiceImp scoreBordDetailServiceImp;

    @Mock
    private ScoreBordDetailsDao scoreBordDetailsDao;
    @Test
    void getScoreBordDetailOfMatch() {

        scoreBordDetailServiceImp.getScoreBordDetailOfMatch(1);
        verify(scoreBordDetailsDao).findBymatchID(1);
    }

    @Test

    void getScoreBordDetailOfMatchUsingTeam() {

        scoreBordDetailServiceImp.getScoreBordDetailOfMatchUsingTeam("india");
        verify(scoreBordDetailsDao).findScoreBordDetailOfMatchUsingTeam("india");
    }
}