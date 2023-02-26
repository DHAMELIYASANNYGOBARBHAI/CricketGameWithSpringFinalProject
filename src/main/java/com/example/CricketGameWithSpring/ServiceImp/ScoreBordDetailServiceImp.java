package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.ScoreBordDetailsDao;
import com.example.CricketGameWithSpring.Entity.ScoreBordDetail;
import com.example.CricketGameWithSpring.Service.ScoreBordDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreBordDetailServiceImp implements ScoreBordDetailService
{
    @Autowired
    private ScoreBordDetailsDao scoreBordDetailsDao;
    @Override
    public ScoreBordDetail getScoreBordDetailOfMatch(int matchId) {
        return scoreBordDetailsDao.findBymatchID(matchId);
    }
    @Override
    public List<ScoreBordDetail> getScoreBordDetailOfMatchUsingTeam(String teamName){
        return scoreBordDetailsDao.findScoreBordDetailOfMatchUsingTeam(teamName);
    }


}
