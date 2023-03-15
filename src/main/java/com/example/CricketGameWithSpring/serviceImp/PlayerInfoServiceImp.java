package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.PlayerInfoDao;
import com.example.CricketGameWithSpring.entity.PlayerInfo;
import com.example.CricketGameWithSpring.entity.PlayerRole;
import com.example.CricketGameWithSpring.service.PlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PlayerInfoServiceImp implements PlayerInfoService {

    @Autowired
    private PlayerInfoDao playerInfoDao;

    @Override
    public List<PlayerInfo> getPlayerInfoByPlayerRole(String playerRole) {
        return playerInfoDao.findByRole(playerRole);
    }

    @Override
    public void checkPlayersInfoPresentOrNot() {
        long tableExists = playerInfoDao.count();
        if (tableExists == 0) {
            Random random = new Random();
            for (int i = 1; i <= 40; i++) {
                int id = i; // generate random ID between 1 and 100
                String name = "Player" + i; // generate player name

                PlayerRole playerRole = PlayerRole.values()[random.nextInt(PlayerRole.values().length)];

               PlayerInfo playerInfo = PlayerInfo.builder()
                        .playerId(id)
                        .playerName(name)
                        .playerRole(playerRole)
                        .build();

                playerInfoDao.save(playerInfo);
            }
        }


    }
}
