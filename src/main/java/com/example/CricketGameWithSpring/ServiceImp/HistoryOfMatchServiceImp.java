package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.HistoryOfMatchDao;
import com.example.CricketGameWithSpring.Entity.HistoryOfMatch;
import com.example.CricketGameWithSpring.Service.HistoryOfMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryOfMatchServiceImp implements HistoryOfMatchService {
    @Autowired
    HistoryOfMatchDao historyOfMatchDao;
    @Override
    public HistoryOfMatch getMatchDetails(int matchId){
        return historyOfMatchDao.findBymatchId(matchId);
    }
}
