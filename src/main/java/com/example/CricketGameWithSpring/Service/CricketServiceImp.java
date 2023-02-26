package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Dao.*;
import com.example.CricketGameWithSpring.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CricketServiceImp implements CricketService {
    @Autowired
    private MatchInfoDao matchInfoDao;
    @Autowired
    private HistoryOfMatchDao historyOfMatchDao;
    @Autowired
    private ScoreBordDetailsDao scoreBordDetailsDao;
    @Autowired
    private PlayerDao playerDao;
    @Autowired
    private PlayerInfoDao playerInfoDao;
    @Autowired
    private TeamDetailDao teamDetailDao;

    @Autowired
    private GameStarterImp gameStarter;
    @Override
    public List<String> startGame(MatchDetails matchDetails){return gameStarter.start(matchDetails);};
    @Override
    public HistoryOfMatch getMatchDetails(int matchId)
    {
        return historyOfMatchDao.findBymatchId(matchId);
    }
    @Override
    public ScoreBordDetail getScoreBordDetailOfMatch(int matchId)
    {
        return scoreBordDetailsDao.findBymatchID(matchId);
    }
    @Override
    public MatchInfo getMatchInfoOfMatch(int matchId) {return matchInfoDao.findById(matchId);}
    @Override
    public List<Player> getPlayerByPlayerName(String playerName)
    {
        return playerDao.findByName(playerName);
    }
    @Override
    public List<PlayerInfo> getPlayerInfoByPlayerName(String playerRole) {return playerInfoDao.findByRole(playerRole);}
    @Override
    public List<TeamDetail> getTeamDetailByTeamName(String teamName) {return teamDetailDao.findTeamDetailByTeamName(teamName);}
    @Override
    public List<ScoreBordDetail>getScoreBordDetailOfMatchUsingTeam(String teamName) {return scoreBordDetailsDao.findScoreBordDetailOfMatchUsingTeam(teamName);}
    @Override
    public List<MatchInfo> getMatchInfoOfMatchUsingTeam(String teamName) {return matchInfoDao.findMatchInfoOfMatchUsingTeam(teamName);}

}
