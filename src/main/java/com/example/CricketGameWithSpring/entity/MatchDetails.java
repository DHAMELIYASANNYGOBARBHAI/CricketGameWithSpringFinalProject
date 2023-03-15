package com.example.CricketGameWithSpring.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchDetails {

    private String team1Name;
    private String team2Name;
    private int overs;
    private List<Integer> team1PlayerId;
    private List<Integer> team2PlayerId;
}
