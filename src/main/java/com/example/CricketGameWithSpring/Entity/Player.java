package com.example.CricketGameWithSpring.Entity;

//import jakarta.persistence.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    private String Name;
    private String Role;
    private int RunScoredByPlayer;
    private int BallsFacedByPlayer;
    private int WicketTakenByPlayer;
    private int BallBowledByPlayer;
    private int RunConsiderByPlayer;
    private String teamName;
    private int matchId;

    public Player(String nameById, String roleById)
    {
        Name = nameById;
        Role = roleById;
    }

    public void addRunByPlayer(int Run) {RunScoredByPlayer += Run;BallsFacedByPlayer++;}
    public void addBallAtWicketDown() {BallsFacedByPlayer++;}
    public void addRunConsiderByPlayer(int Run) {RunConsiderByPlayer +=Run;BallBowledByPlayer++;}
    public void addWicketByPlayer() {WicketTakenByPlayer++;BallBowledByPlayer++;}

}
