package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.MatchInfo;

import java.util.List;

public interface MatchInfoService{
    public List<MatchInfo> getMatchInfoOfMatchUsingTeam(String teamName);
    public MatchInfo getMatchInfoOfMatch(int matchId);
}
