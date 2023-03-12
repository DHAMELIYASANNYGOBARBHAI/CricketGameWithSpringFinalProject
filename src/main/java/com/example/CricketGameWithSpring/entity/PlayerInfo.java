package com.example.CricketGameWithSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Index;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PlayerInfo {

    @Id
    @Index(name = "index_player_id")
    private int playerId;
    @Index(name = "index_player_name")
    private String playerName;
    @Index(name = "index_player_role")
    private String playerRole;


}
