package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.entity.*;
import com.example.CricketGameWithSpring.service.CricketService;
import com.example.CricketGameWithSpring.service.PlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CricketServiceImp implements CricketService {

    @Autowired
    private GameStarterServiceImp gameStarterServiceImp;
    @Autowired
    private PlayerInfoService playerInfoService;

    @Override
    public List<String> startGame(MatchDetails matchDetails) {
        playerInfoService.checkPlayersInfoPresentOrNot();
        return gameStarterServiceImp.start(matchDetails);
    }
}
