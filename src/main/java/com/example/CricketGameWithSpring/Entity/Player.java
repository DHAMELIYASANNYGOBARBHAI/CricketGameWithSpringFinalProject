package com.example.CricketGameWithSpring.Entity;

//import jakarta.persistence.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Index;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PlayerInfoAtEveryMatch")
@IdClass(PlayerId.class)
public class Player {

    @Id
    private Long playerId;
    @Id
    private int matchId;
    @Index(name = "indexPlayerName")
    private String playerName;
    @Index(name = "indexPlayerRole")
    private String playerRole;
    @Index(name = "indexTeamName")
    private String teamName;


    private int runScoredByPlayer=0;
    private int ballsFacedByPlayer=0;
    private int wicketTakenByPlayer=0;
    private int ballBowledByPlayer=0;
    private int runConsiderByPlayer=0;

    public Player(Long playerId, String playerName, String playerRole, String teamName, int matchId) {
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

    public void addBallsFacedByPlayer()
    {
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

    public void addBallBowledByPlayer()
    {
        ballBowledByPlayer++;
    }

}
