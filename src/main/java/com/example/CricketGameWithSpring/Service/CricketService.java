package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.MatchDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CricketService
{
    @Autowired
    public GameStarter gameStarter;
    public ArrayList<String> startGame(MatchDetails matchDetails){
        return gameStarter.start(matchDetails);
    };
}
