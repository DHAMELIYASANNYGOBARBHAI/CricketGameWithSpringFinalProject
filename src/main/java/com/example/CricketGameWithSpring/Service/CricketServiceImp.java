package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Dao.HistoryOfCricketMatchDao;
import com.example.CricketGameWithSpring.Dao.MatchInfoDao;
import com.example.CricketGameWithSpring.Dao.ScoreBordDetailsDao;
import com.example.CricketGameWithSpring.Entity.HistoryOfCricketMatch;
import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Entity.MatchInfo;
import com.example.CricketGameWithSpring.Entity.ScoreBordDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CricketServiceImp implements CricketService {
    @Autowired
    public MatchInfoDao matchInfoDao;
    @Autowired
    public HistoryOfCricketMatchDao historyOfCricketMatchDao;
    @Autowired
    public ScoreBordDetailsDao scoreBordDetailsDao;
    @Autowired
    public GameStarterImp gameStarter;
    public List<String> startGame(MatchDetails matchDetails){
        return gameStarter.start(matchDetails);
    };

    public HistoryOfCricketMatch getMatchDetails(int matchId)
    {
        return historyOfCricketMatchDao.findBymatchId(matchId);
    }

    public ScoreBordDetail getScoreBordDetailOfMatch(int matchId)
    {
        return scoreBordDetailsDao.findBymatchID(matchId);
    }

    public MatchInfo getMatchInfoOfMatch(int matchId)
    {
        return matchInfoDao.findById(matchId);
    }
}
