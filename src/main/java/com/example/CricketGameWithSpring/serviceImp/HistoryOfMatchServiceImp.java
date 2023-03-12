package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.HistoryOfMatchDao;
import com.example.CricketGameWithSpring.entity.HistoryOfMatch;
import com.example.CricketGameWithSpring.service.HistoryOfMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryOfMatchServiceImp implements HistoryOfMatchService {

    @Autowired
    private HistoryOfMatchDao historyOfMatchDao;

    @Override
    public HistoryOfMatch getMatchDetails(int matchId) {
        return historyOfMatchDao.findByMatchId(matchId);
    }
}
