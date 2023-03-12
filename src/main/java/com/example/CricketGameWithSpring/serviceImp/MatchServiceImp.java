package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.entity.*;
import com.example.CricketGameWithSpring.service.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Data
@Service
public class MatchServiceImp implements MatchService {

    @Autowired
    PlayCricketMatchService playCricketMatchService;
    @Autowired
    PrintingScoreBordService printingScoreBordService;
    @Autowired
    SavingDataInDatabaseService savingDataInDatabaseService;
    @Autowired
    ScoreBordService scoreBordService;

    private int matchId;
    private Team team1;
    private Team team2;
    private int Overs;
    private String tossWinnerTeamName;
    private String matchWinnerTeamName;
    private List<String> fullScoreBordDetail;

    //    private ScoreBordService scoreBordService = new ScoreBordServiceImp();

    public int toss() {
        return (int) (Math.random() * 2);
    }

    public List<String> startGame() {

        fullScoreBordDetail = new ArrayList<String>();

        // if team2 win the toss  then ( team2 --> team1 and team1 --> team2)
        if (toss() == 1) {
            Team tempTeam = team1;
            team1 = team2;
            team2 = tempTeam;
        }

        tossWinnerTeamName = team1.getTeamName();

        int scoreOfTeam1 = playCricketMatchService.playCricketMatchBetweenTwoTeam(team1, team2, Overs);
        int scoreOfTeam2 = playCricketMatchService.playCricketMatchBetweenTwoTeam(team2, team1, Overs);
        fullScoreBordDetail = printingScoreBordService.printCricketMatchScoreBordBetweenTwoTeams(this);

        if (scoreOfTeam1 > scoreOfTeam2) {
            matchWinnerTeamName = team1.getTeamName();
        } else {
            matchWinnerTeamName = team2.getTeamName();
        }

        fullScoreBordDetail.addAll(
                scoreBordService.printMatchResult(team1, team2, team1.getScoreOfTeam(), team2.getScoreOfTeam(), Overs));

        savingDataInDatabaseService.savingCricketMatchRelatedDataInDatabase(this);

        return fullScoreBordDetail;
    }


}
