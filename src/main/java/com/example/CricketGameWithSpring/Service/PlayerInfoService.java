package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.PlayerInfo;

import java.util.List;

public interface PlayerInfoService {
    public List<PlayerInfo> getPlayerInfoByPlayerRole(String playerRole);

    public void checkPlayersInfoPresentOrNot();
}
