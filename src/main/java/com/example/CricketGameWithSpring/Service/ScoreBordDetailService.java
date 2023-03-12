package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.ScoreBordDetail;

import java.util.List;

public interface ScoreBordDetailService {
   public ScoreBordDetail getScoreBordDetailOfMatch(int matchId);

    public List<ScoreBordDetail> getScoreBordDetailOfMatchUsingTeam(String teamName);
}
