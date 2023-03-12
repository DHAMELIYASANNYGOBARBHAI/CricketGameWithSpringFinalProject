package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.ScoreBordDetailsDao;
import com.example.CricketGameWithSpring.entity.ScoreBordDetail;
import com.example.CricketGameWithSpring.service.ScoreBordDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreBordDetailServiceImp implements ScoreBordDetailService {

    @Autowired
    private ScoreBordDetailsDao scoreBordDetailsDao;

    @Override
    public ScoreBordDetail getScoreBordDetailOfMatch(int matchId) {
        return scoreBordDetailsDao.findBymatchID(matchId);
    }

    @Override
    public List<ScoreBordDetail> getScoreBordDetailOfMatchUsingTeam(String teamName) {
        return scoreBordDetailsDao.findScoreBordDetailOfMatchUsingTeam(teamName);
    }


}
