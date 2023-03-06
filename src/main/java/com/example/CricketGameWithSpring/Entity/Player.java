package com.example.CricketGameWithSpring.Entity;

//import jakarta.persistence.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Index;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Index(name = "indexPlayerId")
    private Long playerId;
    @Index(name = "indexPlayerName")
    private String playerName;
    @Index(name = "indexPlayerRole")
    private String playerRole;
    @Index(name="indexTeamName")
    private String teamName;
    @Index(name="indexMatchId")
    private int matchId;
    private int runScoredByPlayer;
    private int ballsFacedByPlayer;
    private int wicketTakenByPlayer;
    private int ballBowledByPlayer;
    private int runConsiderByPlayer;

    public Player(Long playerId, String playerName, String playerRole, String teamName, int matchId) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerRole = playerRole;
        this.teamName = teamName;
        this.matchId = matchId;
    }



    public void addRunByPlayer(int run) {runScoredByPlayer += run;ballsFacedByPlayer++;}
    public void addBallAtWicketDown() {ballsFacedByPlayer++;}
    public void addRunConsiderByPlayer(int run) {runConsiderByPlayer +=run;ballBowledByPlayer++;}
    public void addWicketByPlayer() {wicketTakenByPlayer++;ballBowledByPlayer++;}

}
