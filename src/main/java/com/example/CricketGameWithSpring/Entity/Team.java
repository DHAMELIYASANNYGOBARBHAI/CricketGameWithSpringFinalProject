package com.example.CricketGameWithSpring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team
{
    private int MatchId;
    private String TeamName;
    private int Score;
    private int WicketLoss;
    private int OversPlay;
    private List<Player> Players;
    private List<Ball> BallDetails;
    private List<Player> bowlerInTeam;

    public void setMatchId(int matchId) {
        MatchId = matchId;
        for(Player player : Players) {
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
    public List<Player>getPlayers(){return Players;}
    public void addScore(int run)
    {
        Score +=run;
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

    public List<Player>  getBowlerInTeam()
    {
        List<Player>  players = getPlayers();
        List<Player>  bowlerInTeam = new ArrayList<Player>();

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
