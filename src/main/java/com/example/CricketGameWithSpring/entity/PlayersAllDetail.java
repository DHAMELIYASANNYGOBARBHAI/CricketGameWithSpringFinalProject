package com.example.CricketGameWithSpring.entity;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "players_all_detail")
@Builder
public class PlayersAllDetail {


    @Id
    @GeneratedValue
    private String id;

    private Long playerId;
    private int matchId;
    private String playerName;

    @Enumerated(EnumType.STRING)
    private PlayerRole playerRole;
    private String teamName;
    private int runScoredByPlayer;
    private int ballsFacedByPlayer;
    private int wicketTakenByPlayer;
    private int ballBowledByPlayer;
    private int runConsiderByPlayer;




    public PlayersAllDetail(Player player) {
        this.playerId = player.getPlayerId();
        this.playerName = player.getPlayerName();
        this.playerRole = player.getPlayerRole();
        this.teamName = player.getTeamName();
        this.matchId = player.getMatchId();
        this.runScoredByPlayer = player.getRunScoredByPlayer();
        this.ballsFacedByPlayer = player.getBallsFacedByPlayer();
        this.wicketTakenByPlayer = player.getWicketTakenByPlayer();
        this.ballBowledByPlayer = player.getBallBowledByPlayer();
        this.runConsiderByPlayer = player.getRunConsiderByPlayer();
    }
}