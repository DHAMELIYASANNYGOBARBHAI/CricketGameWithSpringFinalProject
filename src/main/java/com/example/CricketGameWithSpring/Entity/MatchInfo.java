package com.example.CricketGameWithSpring.Entity;

import com.example.CricketGameWithSpring.ServiceImp.MatchServiceImp;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "MatchInfo")
@NoArgsConstructor
@AllArgsConstructor
public class MatchInfo
{
    public MatchInfo(int id, String team1Name, String team2Name, String tossWinnerTeamName, String matchWinnerTeamName) {
        this.id = id;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.tossWinnerTeamName = tossWinnerTeamName;
        this.matchWinnerTeamName = matchWinnerTeamName;
    }

    @Id
    @Indexed(name="indexId1")
    private int id;
    @Indexed(name="indexTeam1Name1")
    private String team1Name;
    @Indexed(name="indexTeam2Name1")
    private String team2Name;
    private String tossWinnerTeamName;
    private String matchWinnerTeamName;
    private List<Ball> firstInningOfMatchAllBallDetails;
    private List<Ball> secondInningOfMatchAllBallDetails;
    public MatchInfo(MatchServiceImp matchServiceImp){
        this.id = matchServiceImp.getMatchId();
        this.team1Name = matchServiceImp.getTeam1().getTeamName();
        this.team2Name = matchServiceImp.getTeam2().getTeamName();
        this.tossWinnerTeamName = matchServiceImp.getTossWinnerTeamName();
        this.matchWinnerTeamName = matchServiceImp.getMatchWinnerTeamName();
        this.firstInningOfMatchAllBallDetails = matchServiceImp.getTeam1().getBallDetailsOfTeam();
        this.secondInningOfMatchAllBallDetails = matchServiceImp.getTeam2().getBallDetailsOfTeam();
    }
}
