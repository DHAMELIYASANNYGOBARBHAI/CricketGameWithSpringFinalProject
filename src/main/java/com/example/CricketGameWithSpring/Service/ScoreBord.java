package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.Ball;
import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.Team;

import java.util.ArrayList;

public class ScoreBord
{
    ArrayList<String> PrintScoreBordOfBattingTeam(Team T)
    {

//        System.out.println( T.getTeamName() +" Innings");
//        ArrayList<Player> player = T.getPlayers();
//        System.out.println("+----------------------+----------+-------+----------+");
//        System.out.println("|     Name             |    Role   | Runs  | Balls   |");
//        System.out.println("+----------------------+----------+-------+----------+");
//        for (Player p : player) {
//            System.out.println(String.format("| %-20s | %-8s | %5d | %8d |", p.getName(), p.getRole(), p.getRunScoredByPlayer(), p.getBallsFacedByPlayer()));
//        }
//        System.out.println("+----------------------+----------+-------+----------+");
//
//        System.out.println();
//        System.out.println();
//        System.out.println();


        ArrayList<String> tableRows = new ArrayList<>();
        ArrayList<Player> player = T.getPlayers();
        tableRows.add(T.getTeamName() + " Innings");
        tableRows.add("+----------------------+----------+-------+----------+");
        tableRows.add("|     Name             |    Role   | Runs  | Balls   |");
        tableRows.add("+----------------------+----------+-------+----------+");
        for (Player p : player) {
            tableRows.add(String.format("| %-20s | %-8s | %5d | %8d |", p.getName(), p.getRole(), p.getRunScoredByPlayer(), p.getBallsFacedByPlayer()));
        }
        tableRows.add("+----------------------+----------+-------+----------+");
        tableRows.add("");
        tableRows.add("");
        tableRows.add("");

//        for (String row : tableRows) {
//            System.out.println(row);
//        }

        return tableRows;

    }

    ArrayList<String> PrintScoreBordOfBowlingTeam(Team T)
    {
//        ArrayList<Player>  player = T.getPlayers();
//        System.out.println("+----------------------+----------+-----------+---------------+------------+");
//        System.out.println("|     Name             |    Role  |  Wickets  |  RunConsider  | BallBowled |");
//        System.out.println("+----------------------+----------+-----------+---------------+------------+");
//        for (Player p : player) {
//            if (p.getRole().equals("Bowler"))
//            {
//                System.out.println(String.format("| %-20s | %-8s | %10d | %10d | %10d |", p.getName(), p.getRole(), p.getWicketTakenByPlayer(), p.getRunConsiderByPlayer(),p.getBallBowledByPlayer()));
//
//            }
//        }
//
//        System.out.println("+----------------------+----------+-----------+---------------+------------+");
//
//        System.out.println();
//        System.out.println();
//        System.out.println();


        ArrayList<Player> player = T.getPlayers();
        ArrayList<String> tableRows = new ArrayList<>();

        tableRows.add("+----------------------+----------+-----------+---------------+------------+");
        tableRows.add("|     Name             |    Role  |  Wickets  |  RunConsider  | BallBowled |");
        tableRows.add("+----------------------+----------+-----------+---------------+------------+");
        for (Player p : player) {
            if (p.getRole().equals("Bowler")) {
                tableRows.add(String.format("| %-20s | %-8s | %10d | %10d | %10d |", p.getName(), p.getRole(), p.getWicketTakenByPlayer(), p.getRunConsiderByPlayer(), p.getBallBowledByPlayer()));
            }
        }
        tableRows.add("+----------------------+----------+-----------+---------------+------------+");
        tableRows.add("");
        tableRows.add("");
        tableRows.add("");

        return tableRows;

    }


    ArrayList<String> GetDetailOfBall(Team team) {
//        ArrayList<Ball> BallDetail = team.getBallDetails();
//
//        System.out.println("+---------------------+---------------------+-------+-------+-------+");
//        System.out.println("|    Batsman          |     Bowler          |  Ball |  Over | Runs  |");
//        System.out.println("+---------------------+---------------------+-------+-------+-------+");
//        for (Ball B : BallDetail) {
//            System.out.println(String.format("| %-20s | %-20s | %5d | %5d | %5d |", B.getNameOfBatsman(), B.getNameOfBowler(), B.getSerialNoOfBall(), B.getOverNo(), B.getRuns()));
//        }
//        System.out.println("+---------------------+---------------------+-------+-------+--------+");
//
//        System.out.println();
//        System.out.println();
//        System.out.println();

        ArrayList<String> tableRows = new ArrayList<String>();
        tableRows.add("+---------------------+---------------------+-------+-------+-------+");
        tableRows.add("|    Batsman          |     Bowler          |  Ball |  Over | Runs  |");
        tableRows.add("+---------------------+---------------------+-------+-------+-------+");

        ArrayList<Ball> BallDetail = team.getBallDetails();
        for (Ball B : BallDetail) {
            tableRows.add(String.format("| %-20s | %-20s | %5d | %5d | %5d |", B.getNameOfBatsman(), B.getNameOfBowler(), B.getSerialNoOfBall(), B.getOverNo(), B.getRuns()));
        }
        tableRows.add("+---------------------+---------------------+-------+-------+--------+");
        tableRows.add("");
        tableRows.add("");
        tableRows.add("");

        return tableRows;
    }

    public ArrayList<String> printMatchResult(Team team1, Team team2, int team1Score, int team2Score, int overs) {
        ArrayList<String> result = new ArrayList<String>();
        result.add("+--------------------------------------------------+");
        result.add("|                 Match Result                     |");
        result.add("+--------------------------------------------------+");
        result.add("| Team1: " + team1.getTeamName() + "                                    |");
        result.add("| Team2: " + team2.getTeamName() + "                                 |");
        result.add("| Score: " + team1Score + " / " + team1.getWicketLoss() + " (" + team1.getOversPlay() + " overs)                      |");
        result.add("| Score: " + team2Score + " / " + team2.getWicketLoss() + " (" + team2.getOversPlay() + " overs)                      |");
        result.add("+--------------------------------------------------+");
        if (team1Score > team2Score) {
            result.add("| " + team1.getTeamName() + " won the match                           |");
        } else if (team2Score > team1Score) {
            result.add("| " + team2.getTeamName() + " won the match                           |");
        } else {
            result.add("| The match was a draw                              |");
        }
        result.add("+--------------------------------------------------+");
        return result;
    }


}
