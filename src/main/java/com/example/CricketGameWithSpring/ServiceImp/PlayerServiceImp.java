package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.PlayerDao;
import com.example.CricketGameWithSpring.Elasticsearch.PlayerDaoUsingElasticsearch;
//import com.example.CricketGameWithSpring.Elasticsearch.TempDao;
import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.PlayersAllDetail;
import com.example.CricketGameWithSpring.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService
{
    @Autowired
    PlayerDao playerDao;

    @Autowired
    PlayerDaoUsingElasticsearch playerDaoUsingElasticsearch;

//    @Autowired
//    TempDao tempDao;


    @Override
    public List<Player> getPlayerByPlayerName(String playerName)
    {
        return playerDao.findByName(playerName);
    }

    @Override
    public List<PlayersAllDetail> getPlayerByPlayerNameUsingElasticSearchgetPlayerByPlayerNameUsingElasticsearch(String playerName) {
        return playerDaoUsingElasticsearch.findByPlayerName(playerName);

    }

//    @Override
//    public Player add(Player player) {
//        return tempDao.save(player);
//    }


}
