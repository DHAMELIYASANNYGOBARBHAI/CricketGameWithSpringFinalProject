package com.example.CricketGameWithSpring.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "MatchInfo")
public class MatchInfo
{
    @Id
    private int Id;
    private String team1Name;
    private String team2Name;
    private String tossWinner;
    private String matchWinner;

    private List<Ball> firstInningOfMatchAllBallDetails;
    private List<Ball> secondInningOfMatchAllBallDetails;

}
