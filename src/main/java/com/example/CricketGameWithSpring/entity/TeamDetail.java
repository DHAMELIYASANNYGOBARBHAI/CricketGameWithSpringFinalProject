package com.example.CricketGameWithSpring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Team")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @org.hibernate.annotations.Index(name = "indexId")
    private int id;
    @org.hibernate.annotations.Index(name = "indexMatchId")
    private int matchId;
    @org.hibernate.annotations.Index(name = "indexTeamName")
    private String teamName;
    private int scoreOfTeam;
    private int wicketLossOfTeam;
    private int oversPlayByTeam = 0;

    public TeamDetail(Team team) {
        this.matchId = team.getMatchId();
        this.teamName = team.getTeamName();
        this.scoreOfTeam = team.getScoreOfTeam();
        this.wicketLossOfTeam = team.getWicketLossOfTeam();
        this.oversPlayByTeam = team.getOversPlayByTeam();
    }
}
