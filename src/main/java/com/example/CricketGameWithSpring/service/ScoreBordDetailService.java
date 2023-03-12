package com.example.CricketGameWithSpring.service;

import com.example.CricketGameWithSpring.entity.ScoreBordDetail;

import java.util.List;

public interface ScoreBordDetailService {

    public ScoreBordDetail getScoreBordDetailOfMatch(int matchId);

    public List<ScoreBordDetail> getScoreBordDetailOfMatchUsingTeam(String teamName);
}
