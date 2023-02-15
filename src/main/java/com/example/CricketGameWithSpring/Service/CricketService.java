package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.MatchDetails;

import java.util.ArrayList;


public class CricketService
{



    public ArrayList<String> GameStart()
    {
        GameStarter gs = new GameStarter(); // starting game
         return gs.start();
    }

    public ArrayList<String>  GameStart(MatchDetails matchDetails)
    {
        GameStarter gs = new GameStarter(); // starting game
         return gs.start(matchDetails);
    }
}
