package com.example.CricketGameWithSpring.Service;


import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.PlayersAllDetail;

import java.util.List;

public interface PlayerService {
   public List<Player> getPlayerByPlayerName(String playerName);

   public List<PlayersAllDetail> getPlayerByPlayerNameUsingElasticSearch(String playerName);


}
