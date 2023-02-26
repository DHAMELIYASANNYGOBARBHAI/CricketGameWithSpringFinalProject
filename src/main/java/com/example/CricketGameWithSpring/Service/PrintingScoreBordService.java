package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.ServiceImp.MatchServiceImp;

import java.util.List;


public interface PrintingScoreBordService {
    public List<String> printCricketMatchScoreBordBetweenTwoTeams(MatchServiceImp matchServiceImp);
}
