package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.HistoryOfMatchDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
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