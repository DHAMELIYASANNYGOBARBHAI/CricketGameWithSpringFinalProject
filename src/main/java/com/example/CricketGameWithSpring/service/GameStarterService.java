package com.example.CricketGameWithSpring.service;

import com.example.CricketGameWithSpring.entity.MatchDetails;

import java.util.List;

public interface GameStarterService {

    public List<String> start(MatchDetails matchDetails);
}
