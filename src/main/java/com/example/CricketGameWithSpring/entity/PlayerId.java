package com.example.CricketGameWithSpring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerId implements Serializable {

    private Long playerId;
    private int matchId;
}
