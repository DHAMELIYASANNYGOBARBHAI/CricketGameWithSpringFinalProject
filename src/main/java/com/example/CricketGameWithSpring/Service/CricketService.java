package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.*;

import java.util.List;

public interface CricketService{
    public List<String> startGame(MatchDetails matchDetails);
}
