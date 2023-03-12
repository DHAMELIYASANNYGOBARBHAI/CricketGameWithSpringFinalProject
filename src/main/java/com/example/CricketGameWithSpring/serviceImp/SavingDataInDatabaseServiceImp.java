package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.*;
import com.example.CricketGameWithSpring.elasticsearch.PlayerDaoUsingElasticsearch;
import com.example.CricketGameWithSpring.entity.*;
import com.example.CricketGameWithSpring.service.SavingDataInDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SavingDataInDatabaseServiceImp implements SavingDataInDatabaseService {

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
    @Autowired
    public PlayerDaoUsingElasticsearch playerDaoUsingElasticsearch;

    @Override
    public void savingCricketMatchRelatedDataInDatabase(MatchServiceImp matchServiceImp) {

        savePlayerInfoInDb(matchServiceImp.getTeam1().getPlayersOfTeam(), matchServiceImp.getMatchId());
        savePlayerInfoInDb(matchServiceImp.getTeam2().getPlayersOfTeam(), matchServiceImp.getMatchId());

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

    private void savePlayerInfoInDb(List<Player> playersOfTeam, int matchId) {
        List<PlayersAllDetail> playersAllDetailsOfTeam = new ArrayList<>();

        for (Player player : playersOfTeam) {
            player.setMatchId(matchId);
            playersAllDetailsOfTeam.add(new PlayersAllDetail(player));

        }

        playerDao.saveAll(playersOfTeam);
        playerDaoUsingElasticsearch.saveAll(playersAllDetailsOfTeam);
    }
}
