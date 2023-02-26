package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.ScoreBordDetail;

import java.util.List;

public interface ScoreBordDetailService {
    ScoreBordDetail getScoreBordDetailOfMatch(int matchId);

    List<ScoreBordDetail> getScoreBordDetailOfMatchUsingTeam(String teamName);
}
