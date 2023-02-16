package com.example.CricketGameWithSpring.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Data
@Document(collection = "MatchInfo")
public class MatchInfo
{
    @Id
    private int id;
    private String team1Name;
    private String team2Name;
    private String tossWinner;
    private String matchWinner;

    private ArrayList<Ball> firstInningOfMatchAllBallDetails;
    private ArrayList<Ball> secondInningOfMatchAllBallDetails;

}
