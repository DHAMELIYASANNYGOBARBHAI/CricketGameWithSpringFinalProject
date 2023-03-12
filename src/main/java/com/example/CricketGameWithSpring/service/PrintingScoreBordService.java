package com.example.CricketGameWithSpring.service;

import com.example.CricketGameWithSpring.serviceImp.MatchServiceImp;

import java.util.List;


public interface PrintingScoreBordService {

    public List<String> printCricketMatchScoreBordBetweenTwoTeams(MatchServiceImp matchServiceImp);
}
