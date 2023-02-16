package com.example.CricketGameWithSpring.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Team
{

    private int MatchId;
    private String TeamName;
    private int Score;
    private int WicketLoss;
    private int OversPlay;
    private ArrayList<Player> Players;

    ArrayList<Ball> BallDetails;

    private ArrayList<Player> bowlerInTeam;



    public String getTeamName() {
        return TeamName;
    }

    public void setMatchId(int matchId) {
        MatchId = matchId;

        for(Player player : Players)
        {
            player.setMatchId(matchId);
        }
    }

    public Team(String teamName, ArrayList<Player> players) {
        TeamName = teamName;
        Score = 0;
        WicketLoss = 0;
        OversPlay = 0;
        Players = players;
        BallDetails = new ArrayList<>();
        bowlerInTeam = getBowlerInTeam();

    }

    public int getScore() {
        return Score;
    }

    public ArrayList<Player>  getPlayers()
    {
        return Players;
    }

    public int getWicketLoss() {
        return WicketLoss;
    }

    public int getOversPlay() {
        return OversPlay;
    }

    public void addScore(int run)
    {
        Score +=run;
    }

    public ArrayList<Ball> getBallDetails()
    {
        return BallDetails;
    }

    public void addWicketLoss()
    {
        WicketLoss++;
    }

    public void addOversPlay()
    {
        OversPlay++;
    }

    public void addBallDetails(Ball ball)
    {
        BallDetails.add(ball);
    }

    public ArrayList<Player>  getBowlerInTeam() {
        ArrayList<Player>  players = getPlayers();
        ArrayList<Player>  bowlerInTeam = new ArrayList<Player>();

        for(Player player : players)
        {
            if(player.getRole().equals("Bowler")) {
                bowlerInTeam.add(player);

            }
        }

        return bowlerInTeam;
    }

    public Player getBatsman(int BatsmanNo)
    {
        return Players.get(BatsmanNo);
    }

    public int getNextBowlerNo(int LastBowlerNo){
        int nextBowlerNo = (int)(Math.random()*4);
        while(LastBowlerNo == nextBowlerNo) {
            nextBowlerNo =  (int)(Math.random()*4);
        }
        return nextBowlerNo;
    }

    public Player getBowler(int bowlerNo)
    {
        return bowlerInTeam.get(bowlerNo);
    }

}
