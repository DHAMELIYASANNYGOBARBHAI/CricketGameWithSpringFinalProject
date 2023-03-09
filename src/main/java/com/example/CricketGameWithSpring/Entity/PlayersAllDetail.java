package com.example.CricketGameWithSpring.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "players_all_detail")
public class PlayersAllDetail
{
    @Id
    private Long playerId;
    private String playerName;
    private String playerRole;
    private String teamName;
    private int matchId;
    private int runScoredByPlayer;
    private int ballsFacedByPlayer;
    private int wicketTakenByPlayer;
    private int ballBowledByPlayer;
    private int runConsiderByPlayer;



    public PlayersAllDetail(Player player)
    {
        this.playerId = player.getPlayerId();
        this.playerName = player.getPlayerName();
        this.playerRole = player.getPlayerRole();
        this.teamName = player.getTeamName();
        this.matchId = player.getMatchId();
        this.runScoredByPlayer = player.getRunScoredByPlayer();
        this.ballsFacedByPlayer = player.getBallsFacedByPlayer();
        this.wicketTakenByPlayer =player.getWicketTakenByPlayer();
        this.ballBowledByPlayer = player.getBallBowledByPlayer();
        this.runConsiderByPlayer = player.getRunConsiderByPlayer();
    }
}