package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.PlayerDao;
import com.example.CricketGameWithSpring.elasticsearch.PlayerDaoUsingElasticsearch;
//import com.example.CricketGameWithSpring.Elasticsearch.TempDao;
import com.example.CricketGameWithSpring.entity.Player;
import com.example.CricketGameWithSpring.entity.PlayersAllDetail;
import com.example.CricketGameWithSpring.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private PlayerDaoUsingElasticsearch playerDaoUsingElasticsearch;


    @Override
    public List<Player> getPlayerByPlayerName(String playerName) {
        return playerDao.findByName(playerName);
    }

    @Override
    public List<PlayersAllDetail> getPlayerByPlayerNameUsingElasticSearch(String playerName) {
        return playerDaoUsingElasticsearch.findByPlayerName(playerName);

    }


}
