package com.example.CricketGameWithSpring.Entity;

import com.example.CricketGameWithSpring.InputValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team
{
    private int matchId;
    private String teamName;
    private int scoreOfTeam;
    private int wicketLossOfTeam;
    private int oversPlayByTeam;
    private List<Player> playersOfTeam = new ArrayList<>();
    private List<Ball> ballDetailsOfTeam=new ArrayList<>();
    private List<Player> bowlersInTeam = new ArrayList<>();
    public List<Player>getPlayers(){return playersOfTeam;}
    public void addScore(int run)
    {
        this.scoreOfTeam +=run;
    }
    public void addWicketLoss()
    {
        this.wicketLossOfTeam++;
    }
    public void addOversPlay()
    {
        this.oversPlayByTeam++;
    }
    public void addBallDetails(Ball ball) {this.ballDetailsOfTeam.add(ball);}
    public void setMatchId(int matchId){
        this.matchId = matchId;
        for(Player player : this.playersOfTeam){player.setMatchId(matchId);}
    }
    public List<Player> getBowlerInTeam(){
        List<Player> players = getPlayers();
        List<Player> bowlerInTeam = players.stream()
                .filter(player -> player.getPlayerRole().equals("Bowler"))
                .collect(Collectors.toList());
        if(bowlerInTeam.size()==1) {throw new InputValidationException("In " + this.getTeamName() + " Team You are only insert One Bowler you need atLeast Two Bowler");};
        return bowlerInTeam;
    }
    public Player getBatsman(int BatsmanNo){return playersOfTeam.get(BatsmanNo);}
    public int getNextBowlerNo(int LastBowlerNo){
        int numberOfBowlerInTeam = bowlersInTeam.size();
        int nextBowlerNo = (int)(Math.random()*numberOfBowlerInTeam);
        while(LastBowlerNo == nextBowlerNo){nextBowlerNo =  (int)(Math.random()*numberOfBowlerInTeam);}
        return nextBowlerNo;
    }
    public Player getBowler(int bowlerNo)
    {
        return bowlersInTeam.get(bowlerNo);
    }

}
