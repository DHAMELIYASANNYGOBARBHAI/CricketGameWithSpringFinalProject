package com.example.CricketGameWithSpring.Service;


import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.PlayersAllDetail;

import java.util.List;

public interface PlayerService {
    List<Player> getPlayerByPlayerName(String playerName);

    List<PlayersAllDetail> getPlayerByPlayerNameUsingElasticSearchgetPlayerByPlayerNameUsingElasticsearch(String playerName);


}
