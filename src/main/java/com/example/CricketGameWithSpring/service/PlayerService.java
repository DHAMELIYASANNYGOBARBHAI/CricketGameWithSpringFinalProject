package com.example.CricketGameWithSpring.service;


import com.example.CricketGameWithSpring.entity.Player;
import com.example.CricketGameWithSpring.entity.PlayersAllDetail;

import java.util.List;

public interface PlayerService {

    public List<Player> getPlayerByPlayerName(String playerName);

    public List<PlayersAllDetail> getPlayerByPlayerNameUsingElasticSearch(String playerName);


}
