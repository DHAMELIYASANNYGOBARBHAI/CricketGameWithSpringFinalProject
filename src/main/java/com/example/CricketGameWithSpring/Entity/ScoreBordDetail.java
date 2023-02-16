package com.example.CricketGameWithSpring.Entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "ScoreBordDetail")
public class ScoreBordDetail
{
    @Id
    private int matchID;
    private String team1Name;
    private int scoreOfTeam1;
    private int wicketLossOfTeam1;
    private int oversPlayByTeam1;

    ArrayList<Player> playersOfTeam1;

    private String team2Name;
    private int scoreOfTeam2;
    private int wicketLossOfTeam2;
    private int oversPlayByTeam2;

    ArrayList<Player> playersOfTeam2;

}
