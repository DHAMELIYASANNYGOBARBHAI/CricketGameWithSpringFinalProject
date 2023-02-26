package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.PlayerInfoDao;
import com.example.CricketGameWithSpring.Entity.PlayerInfo;
import com.example.CricketGameWithSpring.Service.PlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerInfoServiceImp implements PlayerInfoService {
    @Autowired
    PlayerInfoDao playerInfoDao;
    @Override
    public List<PlayerInfo> getPlayerInfoByPlayerName(String playerRole) {return playerInfoDao.findByRole(playerRole);}
}
