package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.entity.Ball;
import com.example.CricketGameWithSpring.entity.Player;
import com.example.CricketGameWithSpring.entity.Team;
import com.example.CricketGameWithSpring.service.ScoreBordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ScoreBordServiceImp implements ScoreBordService {


    public List<String> printScoreBordOfBattingTeam(Team T) {
        List<String> tableRows = new ArrayList<>();
        List<Player> player = T.getPlayers();
        tableRows.add(T.getTeamName() + " Innings");
        tableRows.add("+----------------------+----------+-------+----------+");
        tableRows.add("|     Name             |    Role   | Runs  | Balls   |");
        tableRows.add("+----------------------+----------+-------+----------+");
        for (Player p : player) {
            tableRows.add(String.format("| %-20s | %-8s | %5d | %8d |", p.getPlayerName(), p.getPlayerRole(),
                    p.getRunScoredByPlayer(), p.getBallsFacedByPlayer()));
        }
        tableRows.add("+----------------------+----------+-------+----------+");
        tableRows.add("");
        tableRows.add("");
        tableRows.add("");

        return tableRows;

    }

    public List<String> printScoreBordOfBowlingTeam(Team T) {


        List<Player> player = T.getPlayers();
        List<String> tableRows = new ArrayList<>();

        tableRows.add("+----------------------+----------+-----------+---------------+------------+");
        tableRows.add("|     Name             |    Role  |  Wickets  |  RunConsider  | BallBowled |");
        tableRows.add("+----------------------+----------+-----------+---------------+------------+");
        for (Player p : player) {
            if (p.getPlayerRole().equals("Bowler") || p.getPlayerRole().equals("All-rounder")) {
                tableRows.add(
                        String.format("| %-20s | %-8s | %10d | %10d | %10d |", p.getPlayerName(), p.getPlayerRole(),
                                p.getWicketTakenByPlayer(), p.getRunConsiderByPlayer(), p.getBallBowledByPlayer()));
            }
        }
        tableRows.add("+----------------------+----------+-----------+---------------+------------+");
        tableRows.add("");
        tableRows.add("");
        tableRows.add("");

        return tableRows;

    }


    public List<String> getDetailOfBall(Team team) {
        List<String> tableRows = new ArrayList<String>();
        tableRows.add("+---------------------+---------------------+-------+-------+-------+");
        tableRows.add("|    Batsman          |     Bowler          |  Ball |  Over | Runs  |");
        tableRows.add("+---------------------+---------------------+-------+-------+-------+");

        List<Ball> BallDetail = team.getBallDetailsOfTeam();
        for (Ball B : BallDetail) {
            tableRows.add(String.format("| %-20s | %-20s | %5d | %5d | %5d |", B.getNameOfBatsmanWhoPlayBall(),
                    B.getNameOfBowlerWhoBowledBall(), B.getSerialNoOfBall(), B.getOverNoOfBall(),
                    B.getRunsCoveredOnBall()));
        }
        tableRows.add("+---------------------+---------------------+-------+-------+--------+");
        tableRows.add("");
        tableRows.add("");
        tableRows.add("");

        return tableRows;
    }

    public List<String> printMatchResult(Team team1, Team team2, int team1Score, int team2Score, int overs) {
        List<String> result = new ArrayList<String>();
        result.add("+--------------------------------------------------+");
        result.add("|                 MatchImp Result                     |");
        result.add("+--------------------------------------------------+");
        result.add("| Team1: " + team1.getTeamName() + "                                    |");
        result.add("| Team2: " + team2.getTeamName() + "                                 |");
        result.add("| Score: " + team1Score + " / " + team1.getWicketLossOfTeam() + " (" + team1.getOversPlayByTeam() +
                   " overs)                      |");
        result.add("| Score: " + team2Score + " / " + team2.getWicketLossOfTeam() + " (" + team2.getOversPlayByTeam() +
                   " overs)                      |");
        result.add("+--------------------------------------------------+");
        if (team1Score > team2Score) {
            result.add("| " + team1.getTeamName() + " won the matchImp                           |");
        } else if (team2Score > team1Score) {
            result.add("| " + team2.getTeamName() + " won the matchImp                           |");
        } else {
            result.add("| The matchImp was a draw                              |");
        }
        result.add("+--------------------------------------------------+");
        return result;
    }


}
