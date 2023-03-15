package com.example.CricketGameWithSpring.entity;

//import jakarta.persistence.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Index;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PlayerInfoAtEveryMatch")
@IdClass(PlayerId.class)
@Builder
public class Player {

    @Id
    private Long playerId;
    @Id
    private int matchId;
    @Index(name = "indexPlayerName")
    private String playerName;

    @Index(name = "indexPlayerRole")
    @Enumerated(EnumType.STRING)
    private PlayerRole playerRole;

    @Index(name = "indexTeamName")
    private String teamName;


    private int runScoredByPlayer;
    private int ballsFacedByPlayer;
    private int wicketTakenByPlayer;
    private int ballBowledByPlayer;
    private int runConsiderByPlayer;

    public Player(Long playerId, String playerName, PlayerRole playerRole, String teamName, int matchId) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerRole = playerRole;
        this.teamName = teamName;
        this.matchId = matchId;
    }


    public void addRunByPlayer(int run) {
        runScoredByPlayer += run;
        //ballsFacedByPlayer++;
    }

    public void addBallsFacedByPlayer() {
        ballsFacedByPlayer++;
    }

    //    public void addBallAtWicketDown() {
    //        ballsFacedByPlayer++;
    //    }

    public void addRunConsiderByPlayer(int run) {
        runConsiderByPlayer += run;
        //ballBowledByPlayer++;
    }

    public void addWicketByPlayer() {
        wicketTakenByPlayer++;
        //ballBowledByPlayer++;
    }

    public void addBallBowledByPlayer() {
        ballBowledByPlayer++;
    }


}
