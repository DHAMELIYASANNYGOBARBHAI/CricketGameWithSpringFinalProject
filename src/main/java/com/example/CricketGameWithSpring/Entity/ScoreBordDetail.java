package com.example.CricketGameWithSpring.Entity;

import com.example.CricketGameWithSpring.Service.MatchServiceImp;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ScoreBordDetail")
public class ScoreBordDetail
{
    @Id
    @Indexed(name="indexMatchId")
    private int matchID;
    @Indexed(name="indexTeam1Name")
    private String team1Name;
    @Indexed
    private String team2Name;
    private int scoreOfTeam1;
    private int wicketLossOfTeam1;
    private int oversPlayByTeam1;
    private List<Player> playersOfTeam1;
    private int scoreOfTeam2;
    private int wicketLossOfTeam2;
    private int oversPlayByTeam2;
    private List<Player> playersOfTeam2;
    public ScoreBordDetail(MatchServiceImp matchServiceImp)
    {
        this.matchID = matchServiceImp.getMatchId();
        this.team1Name = matchServiceImp.getTeam1().getTeamName();
        this.team2Name = matchServiceImp.getTeam2().getTeamName();
        this.scoreOfTeam1 = matchServiceImp.getTeam1().getScoreOfTeam();
        this.wicketLossOfTeam1 = matchServiceImp.getTeam1().getWicketLossOfTeam();
        this.oversPlayByTeam1 = matchServiceImp.getTeam1().getOversPlayByTeam();
        this.playersOfTeam1 = matchServiceImp.getTeam1().getPlayersOfTeam();
        this.scoreOfTeam2 = matchServiceImp.getTeam2().getScoreOfTeam();
        this.wicketLossOfTeam2 =  matchServiceImp.getTeam2().getWicketLossOfTeam();
        this.oversPlayByTeam2 = matchServiceImp.getTeam2().getOversPlayByTeam();
        this.playersOfTeam2 = matchServiceImp.getTeam2().getPlayersOfTeam();
    }
}
