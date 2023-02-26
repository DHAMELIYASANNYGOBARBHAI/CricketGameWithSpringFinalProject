package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getPlayerByPlayerName(String playerName);
}
