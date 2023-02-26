package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.MatchInfoDao;
import com.example.CricketGameWithSpring.Entity.MatchInfo;
import com.example.CricketGameWithSpring.Service.MatchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchInfoServiceImp implements MatchInfoService {

    @Autowired
    MatchInfoDao matchInfoDao;
    @Override
    public List<MatchInfo> getMatchInfoOfMatchUsingTeam(String teamName) {return matchInfoDao.findMatchInfoOfMatchUsingTeam(teamName);}
    @Override
    public MatchInfo getMatchInfoOfMatch(int matchId) {return matchInfoDao.findById(matchId);}
}
