package com.example.CricketGameWithSpring.service;

import com.example.CricketGameWithSpring.entity.*;

import java.util.List;

public interface CricketService {

    public List<String> startGame(MatchDetails matchDetails);
}
