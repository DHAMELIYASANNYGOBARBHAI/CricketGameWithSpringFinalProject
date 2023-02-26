package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.*;
import com.example.CricketGameWithSpring.Entity.*;
import com.example.CricketGameWithSpring.Service.SavingDataInDatabaseService;
import com.example.CricketGameWithSpring.ServiceImp.MatchServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingDataInDatabaseServiceImp implements SavingDataInDatabaseService
{
    @Autowired
    public ScoreBordDetailsDao scoreBordDetailsDao;
    @Autowired
    public PlayerDao playerDao;
    @Autowired
    public TeamDetailDao teamDetailDao;
    @Autowired
    public MatchInfoDao matchInfoDao;
    @Autowired
    public HistoryOfMatchDao historyOfCricketMatchDao;
    @Override
    public void savingCricketMatchRelatedDataInDatabase(MatchServiceImp matchServiceImp){

        for(Player player:matchServiceImp.getTeam1().getPlayersOfTeam()) playerDao.save(player);
        for(Player player:matchServiceImp.getTeam2().getPlayersOfTeam()) playerDao.save(player);

        TeamDetail team1Detail = new TeamDetail(matchServiceImp.getTeam1());
        teamDetailDao.save(team1Detail);

        TeamDetail team2Detail = new TeamDetail(matchServiceImp.getTeam2());
        teamDetailDao.save(team2Detail);

        ScoreBordDetail scoreBordDetail = new ScoreBordDetail(matchServiceImp);
        scoreBordDetailsDao.save(scoreBordDetail);

        MatchInfo matchInfo = new MatchInfo(matchServiceImp);
        matchInfoDao.save(matchInfo);

        HistoryOfMatch historyOfCricketMatch = new HistoryOfMatch(matchServiceImp);
        historyOfCricketMatchDao.save(historyOfCricketMatch);
    }
}
