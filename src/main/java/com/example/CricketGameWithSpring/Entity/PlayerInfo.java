package com.example.CricketGameWithSpring.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Index;

@Data
@Entity
public class PlayerInfo
{
    @Id
    @Index(name="index_player_id")
    private int playerId;
    @Index(name="index_player_name")
    private String playerName;
    @Index(name="index_player_role")
    private String  playerRole;
}
