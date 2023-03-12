package com.example.CricketGameWithSpring.service;

import com.example.CricketGameWithSpring.entity.MatchInfo;

import java.util.List;

public interface MatchInfoService {

    public List<MatchInfo> getMatchInfoOfMatchUsingTeam(String teamName);

    public MatchInfo getMatchInfoOfMatch(int matchId);
}
