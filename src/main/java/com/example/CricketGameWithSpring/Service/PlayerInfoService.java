package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.PlayerInfo;

import java.util.List;

public interface PlayerInfoService {
    List<PlayerInfo> getPlayerInfoByPlayerName(String playerRole);
}
