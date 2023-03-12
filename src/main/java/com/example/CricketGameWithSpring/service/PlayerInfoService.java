package com.example.CricketGameWithSpring.service;

import com.example.CricketGameWithSpring.entity.PlayerInfo;

import java.util.List;

public interface PlayerInfoService {

    public List<PlayerInfo> getPlayerInfoByPlayerRole(String playerRole);

    public void checkPlayersInfoPresentOrNot();
}
