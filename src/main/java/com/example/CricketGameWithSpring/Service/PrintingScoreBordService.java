package com.example.CricketGameWithSpring.Service;

import org.springframework.stereotype.Service;

import java.util.List;


public interface PrintingScoreBordService {
    public List<String> printCricketMatchScoreBordBetweenTwoTeams(MatchServiceImp matchServiceImp);
}
