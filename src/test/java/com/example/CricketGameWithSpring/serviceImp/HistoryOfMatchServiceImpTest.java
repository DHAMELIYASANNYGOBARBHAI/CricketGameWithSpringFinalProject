package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.HistoryOfMatchDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class HistoryOfMatchServiceImpTest {

    @MockBean
    HistoryOfMatchDao historyOfMatchDao;
    @InjectMocks
    HistoryOfMatchServiceImp historyOfMatchServiceImp;
    @Test
    void getMatchDetails()
    {
        historyOfMatchServiceImp.getMatchDetails(1);
        verify(historyOfMatchDao).findByMatchId(1);
    }
}