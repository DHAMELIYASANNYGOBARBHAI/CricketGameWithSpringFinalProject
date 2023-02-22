package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.HistoryOfCricketMatch;
import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Entity.MatchInfo;
import com.example.CricketGameWithSpring.Entity.ScoreBordDetail;

import java.util.List;

public interface CricketService
{
    public List<String> startGame(MatchDetails matchDetails);
    public HistoryOfCricketMatch getMatchDetails(int matchId);
    public ScoreBordDetail getScoreBordDetailOfMatch(int matchId);
    public MatchInfo getMatchInfoOfMatch(int matchId);
}
