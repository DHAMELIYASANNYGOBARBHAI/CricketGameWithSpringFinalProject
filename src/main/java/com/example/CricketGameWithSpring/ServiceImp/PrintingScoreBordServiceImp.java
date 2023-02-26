package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Service.PrintingScoreBordService;
import com.example.CricketGameWithSpring.ServiceImp.MatchServiceImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrintingScoreBordServiceImp implements PrintingScoreBordService
{
    public List<String> printCricketMatchScoreBordBetweenTwoTeams(MatchServiceImp matchServiceImp) {

        ArrayList<String> scoreBoardInformation = new ArrayList<>();

        // 1st inning
        List<String> team1BattingDetail = matchServiceImp.getScoreBordService().PrintScoreBordOfBattingTeam(matchServiceImp.getTeam1());
        scoreBoardInformation.addAll(team1BattingDetail);

        List<String> team2BowlingDetail = matchServiceImp.getScoreBordService().PrintScoreBordOfBowlingTeam(matchServiceImp.getTeam2());
        scoreBoardInformation.addAll(team2BowlingDetail);

        List<String> inning1BallDetail = matchServiceImp.getScoreBordService().GetDetailOfBall(matchServiceImp.getTeam1());
        scoreBoardInformation.addAll(inning1BallDetail);

        // 2nd inning
        List<String> team2BattingDetail = matchServiceImp.getScoreBordService().PrintScoreBordOfBattingTeam(matchServiceImp.getTeam2());
        scoreBoardInformation.addAll(team2BattingDetail);

        List<String> team1BowlingDetail = matchServiceImp.getScoreBordService().PrintScoreBordOfBowlingTeam(matchServiceImp.getTeam1());
        scoreBoardInformation.addAll(team1BowlingDetail);

        List<String> inning2BallDetail = matchServiceImp.getScoreBordService().GetDetailOfBall(matchServiceImp.getTeam2());
        scoreBoardInformation.addAll(inning2BallDetail);

        return scoreBoardInformation;
    }
}
