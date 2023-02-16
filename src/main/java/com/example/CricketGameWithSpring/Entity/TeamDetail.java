package com.example.CricketGameWithSpring.Entity;

import com.example.CricketGameWithSpring.Service.Match;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Optional;

@Entity
@Table(name = "team")
@Data
public class TeamDetail
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int MatchId;
    private String TeamName;
    private int Score;
    private int WicketLoss;
    private int OversPlay;

    public TeamDetail(Team team)
    {
        MatchId = team.getMatchId();
        TeamName = team.getTeamName();
        Score = team.getScore();
        WicketLoss = team.getWicketLoss();
        OversPlay = team.getOversPlay();
    }

}
