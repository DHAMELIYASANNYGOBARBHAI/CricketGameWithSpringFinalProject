package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.PlayerInfo;

import java.util.List;

public interface PlayerInfoService {
    List<PlayerInfo> getPlayerInfoByPlayerRole(String playerRole);

    void checkPlayersInfoPresentOrNot();
}
