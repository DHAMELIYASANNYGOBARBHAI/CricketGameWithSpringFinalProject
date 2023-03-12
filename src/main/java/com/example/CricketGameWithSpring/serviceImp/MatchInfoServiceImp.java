package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.MatchInfoDao;
import com.example.CricketGameWithSpring.entity.MatchInfo;
import com.example.CricketGameWithSpring.service.MatchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchInfoServiceImp implements MatchInfoService {

    @Autowired
    private MatchInfoDao matchInfoDao;

    @Override
    public List<MatchInfo> getMatchInfoOfMatchUsingTeam(String teamName) {
        return matchInfoDao.findMatchInfoOfMatchUsingTeam(teamName);
    }

    @Override
    public MatchInfo getMatchInfoOfMatch(int matchId) {
        return matchInfoDao.findById(matchId);
    }
}
