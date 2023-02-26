package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.PlayerDao;
import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService
{
    @Autowired
    PlayerDao playerDao;
    @Override
    public List<Player> getPlayerByPlayerName(String playerName)
    {
        return playerDao.findByName(playerName);
    }
}
