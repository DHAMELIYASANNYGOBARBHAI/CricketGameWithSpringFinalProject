package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.PlayerInfoDao;
import com.example.CricketGameWithSpring.Entity.PlayerInfo;
import com.example.CricketGameWithSpring.Service.PlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PlayerInfoServiceImp implements PlayerInfoService {
    @Autowired
    PlayerInfoDao playerInfoDao;
    @Override
    public List<PlayerInfo> getPlayerInfoByPlayerRole(String playerRole) {return playerInfoDao.findByRole(playerRole);}

    @Override
    public void checkPlayersInfoPresentOrNot() {
        long tableExists = playerInfoDao.count();
        if (tableExists==0) {


            Random random = new Random();

            for (int i = 1; i <= 35; i++) {
                int id = i; // generate random ID between 1 and 100
                String name = "Player" + i; // generate player name
                String[] roles = {"Batsman", "Bowler", "All-rounder"}; // list of possible roles
                String role = roles[random.nextInt(roles.length)]; // generate random role from list
                PlayerInfo playerInfo = new PlayerInfo(id, name, role);
                playerInfoDao.save(playerInfo);


            }
        }



    }
}
