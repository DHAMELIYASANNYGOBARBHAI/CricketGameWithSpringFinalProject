package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.entity.*;
import com.example.CricketGameWithSpring.exception.InputValidationException;
import com.example.CricketGameWithSpring.service.CricketService;
import com.example.CricketGameWithSpring.service.PlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CricketServiceImp implements CricketService {

    @Autowired
    private GameStarterServiceImp gameStarterServiceImp;
    @Autowired
    private PlayerInfoService playerInfoService;

    @Override
    public List<String> startGame(MatchDetails matchDetails) {
        playerInfoService.checkPlayersInfoPresentOrNot();
        checkValidationOfMatchDetails(matchDetails);
        return gameStarterServiceImp.start(matchDetails);
    }

    private void checkValidationOfMatchDetails(MatchDetails matchDetails) {

        if(matchDetails.getTeam1Name()==matchDetails.getTeam2Name())
        {
            throw new InputValidationException("Both Of Team Has Same Name");
        }

        List<Integer> team1PlayerId = matchDetails.getTeam1PlayerId();
        List<Integer> team2PlayerId = matchDetails.getTeam2PlayerId();

        if(team1PlayerId.size() != team2PlayerId.size()  || team1PlayerId.size()!=11)
            throw new InputValidationException("check your team playerId array");

        Set<Integer> allPlayerIds1 = new HashSet<>();
        Set<Integer> allPlayerIds2 = new HashSet<>();

        allPlayerIds2.addAll(team2PlayerId);
        allPlayerIds1.addAll(team1PlayerId);

        if(allPlayerIds1.size() !=team1PlayerId.size())
        {
            throw new InputValidationException("Repeated PlayerId in " + matchDetails.getTeam1Name() + " team.");
        }

        if(allPlayerIds2.size()!=team2PlayerId.size())
        {
            throw new InputValidationException("Repeated PlayerId in " + matchDetails.getTeam2Name() + " team.");
        }

        Set<Integer> allPlayerIds = new HashSet<>();

        allPlayerIds.addAll(allPlayerIds1);
        allPlayerIds.addAll(allPlayerIds2);

        if(allPlayerIds.size() != team1PlayerId.size()+team2PlayerId.size())
        {
            throw new InputValidationException("Same PlayerId exist in Both of the team");
        }

    }
}
