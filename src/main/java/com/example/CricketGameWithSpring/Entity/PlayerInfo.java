package com.example.CricketGameWithSpring.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PlayerInfo
{
    @Id
    private int player_id;
    private String player_name;
    private String  player_role;
}
