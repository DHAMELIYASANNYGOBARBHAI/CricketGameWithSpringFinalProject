package com.example.CricketGameWithSpring.entity;

import com.example.CricketGameWithSpring.exception.InputValidationException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Team {

    private int matchId;
    private String teamName;
    private int scoreOfTeam;
    private int wicketLossOfTeam;
    private int oversPlayByTeam;
    private List<Player> playersOfTeam;
    private List<Ball> ballDetailsOfTeam;
    private List<Player> bowlersInTeam;

    public Team(int matchId, String teamName, List<Player> playersOfTeam, List<Player> bowlersInTeam) {
        this.matchId = matchId;
        this.teamName = teamName;
        this.playersOfTeam = playersOfTeam;
        this.bowlersInTeam = bowlersInTeam;
    }

    public List<Player> getPlayers() {
        return playersOfTeam;
    }

    public void addScore(int run) {
        this.scoreOfTeam += run;
    }

    public void addWicketLoss() {
        this.wicketLossOfTeam++;
    }

    public void addOversPlay() {
        this.oversPlayByTeam++;
    }

    public void addBallDetails(Ball ball) {
        this.ballDetailsOfTeam.add(ball);
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
        for (Player player : this.playersOfTeam) {
            player.setMatchId(matchId);
        }
    }

    public List<Player> getBowlerOrAllRounderInTeam() {
        List<Player> players = getPlayers();

        List<Player> bowlerOrAllRounderInTeam = players.stream().filter(player -> {
            String role = player.getPlayerRole().name();
            return role != null && (role.equals("Bowler") || role.equals("AllRounder"));
        }).collect(Collectors.toList());

        if (bowlerOrAllRounderInTeam.size() == 1) {
            throw new InputValidationException("You have only inserted one bowler in the " + this.getTeamName() +
                                               " team. You need to have at least two bowlers.");
        }
        ;
        return bowlerOrAllRounderInTeam;


    }

    public Player getBatsman(int BatsmanNo) {
        return playersOfTeam.get(BatsmanNo);
    }

    public int getNextBowlerNo(int LastBowlerNo) {
        int numberOfBowlerInTeam = bowlersInTeam.size();
        int nextBowlerNo = (int) (Math.random() * numberOfBowlerInTeam);
        while (LastBowlerNo == nextBowlerNo) {
            nextBowlerNo = (int) (Math.random() * numberOfBowlerInTeam);
        }
        return nextBowlerNo;
    }

    public Player getBowler(int bowlerNo) {
        return bowlersInTeam.get(bowlerNo);
    }

}
