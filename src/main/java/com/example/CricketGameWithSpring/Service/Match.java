package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Dao.MatchInfoDao;
import com.example.CricketGameWithSpring.Dao.PlayerDao;
import com.example.CricketGameWithSpring.Dao.ScoreBordDetailsDao;
import com.example.CricketGameWithSpring.Dao.TeamDao;
import com.example.CricketGameWithSpring.Entity.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Data
@Service
public class Match
{
    private int matchId;
    @Autowired
    public ScoreBordDetailsDao scoreBordDetailsDao;
    @Autowired
    public  PlayerDao playerDao;
    @Autowired
    public  TeamDao teamDao;
    @Autowired
    public  MatchInfoDao matchInfoDao;
    Team team1;
    Team team2;
    public static final int numOfBallInOver = 6;
    public static final int wicketNumber = 7;
    public static final int lastWicket = 10;
    public static final int six = 6;
    public static final int four = 4;
    private int Overs;
    private ScoreBord scoreBord = new ScoreBord();
    public ArrayList<String> startGame()
    {
        ScoreBordDetail scoreBordDetail = new ScoreBordDetail();

        MatchInfo matchInfo = new MatchInfo();
        MatchInfo lastDocument = matchInfoDao.findFirstByOrderByIdDesc().orElse(null);

        if(lastDocument==null) matchId=1;
        else matchId = lastDocument.getId()+1;

        matchInfo.setId(matchId);
        scoreBordDetail.setMatchID(matchId);

        team1.setMatchId(matchId);
        team2.setMatchId(matchId);


        ArrayList<String> fullScoreBordDetail = new ArrayList<String>();

        if(toss()==1)  // it is  decided which team play first
        {
            matchInfo.setTossWinner(team1.getTeamName());

            int scoreOfTeam1  = playGame(team1,team2);
            int scoreOfTeam2  = playGame(team2,team1);
            fullScoreBordDetail = printScoreBord(team1,team2);

            matchInfo.setFirstInningOfMatchAllBallDetails(team1.getBallDetails());
            matchInfo.setSecondInningOfMatchAllBallDetails(team2.getBallDetails());

            if(scoreOfTeam1 > scoreOfTeam2)
               matchInfo.setMatchWinner(team1.getTeamName());
            else
                matchInfo.setMatchWinner(team2.getTeamName());
        }
        else
        {
            matchInfo.setTossWinner(team2.getTeamName());
            int scoreOfTeam2  = playGame(team2,team1);
            int scoreOfTeam1  = playGame(team1,team2);
            fullScoreBordDetail = printScoreBord(team2,team1);

            matchInfo.setFirstInningOfMatchAllBallDetails(team2.getBallDetails());
            matchInfo.setSecondInningOfMatchAllBallDetails(team1.getBallDetails());

            if(scoreOfTeam1 > scoreOfTeam2)
                matchInfo.setMatchWinner(team1.getTeamName());
            else
                matchInfo.setMatchWinner(team2.getTeamName());
        }


        fullScoreBordDetail.addAll(scoreBord.printMatchResult(team1,team2,team1.getScore(), team2.getScore(), Overs));

        ArrayList<Player> playersOfTeam1 = team1.getPlayers();
        ArrayList<Player> playersOfTeam2 = team2.getPlayers();

        for(Player p : playersOfTeam1) playerDao.save(p);
        for(Player p : playersOfTeam2) playerDao.save(p);

        TeamDetail team1Detail = new TeamDetail(team1);
        TeamDetail team2Detail = new TeamDetail(team2);

        teamDao.save(team1Detail);
        teamDao.save(team2Detail);

        matchInfo.setTeam1Name(team1.getTeamName());
        matchInfo.setTeam2Name(team2.getTeamName());
        matchInfoDao.save(matchInfo);

          scoreBordDetail.setTeam1Name(team1.getTeamName());
          scoreBordDetail.setScoreOfTeam1(team1.getScore());
          scoreBordDetail.setOversPlayByTeam1(team1.getOversPlay());
          scoreBordDetail.setWicketLossOfTeam1(team1.getWicketLoss());
          scoreBordDetail.setPlayersOfTeam1(team1.getPlayers());

          scoreBordDetail.setTeam2Name(team2.getTeamName());
          scoreBordDetail.setScoreOfTeam2(team2.getScore());
          scoreBordDetail.setWicketLossOfTeam2(team2.getWicketLoss());
          scoreBordDetail.setOversPlayByTeam2(team2.getOversPlay());
          scoreBordDetail.setPlayersOfTeam2(team2.getPlayers());

          scoreBordDetailsDao.save(scoreBordDetail);


        return fullScoreBordDetail;
    }
    private int toss()
    {
        return (int)(Math.random()*2);
    }
    private int playGame(Team team1,Team team2) {
        int batsmanNo = 0;
        int lastBowlerNo = -1;

        Player batsman1 = team1.getBatsman(batsmanNo++); // on strike
        Player batsman2 = team1.getBatsman(batsmanNo++); // off side



        for(int i=0;i<Overs;i++)
        {

            int NextBowlerNo = team2.getNextBowlerNo(lastBowlerNo);
            Player Bowler = team2.getBowler(NextBowlerNo);
            lastBowlerNo = NextBowlerNo;

            for(int j=0;j<numOfBallInOver;j++)
            {
                int run = RandomFunction();

                if(run==wicketNumber)
                {
                    // consider as wicket for Now
                    Ball ball = new Ball(i,j,batsman1.getName(),Bowler.getName(),0,true);
                    Bowler.addWicketByPlayer();
                    batsman1.addBallAtWicketDown();
                    team1.addBallDetails(ball);
                    team1.addWicketLoss();
                    if(team1.getWicketLoss() == lastWicket) {return team1.getScore();}
                    batsman1 = team1.getBatsman(batsmanNo++);
                }
                else
                {
                    // 0,1,2,3,4,5,6
                    Ball ball = new Ball(i,j,batsman1.getName(),Bowler.getName(),run,false);
                    batsman1.addRunByPlayer(run);
                    Bowler.addRunConsiderByPlayer(run);
                    team1.addScore(run);
                    team1.addBallDetails(ball);
                    if((run%2) == 1) {
                        // Strike change  by batsman at run : 1,3,5
                        ArrayList<Player> newPositionOfBatsman=  StrikeChange(batsman1,batsman2);
                        batsman1 = newPositionOfBatsman.get(0);
                        batsman2 = newPositionOfBatsman.get(1);
                    }


                }


            }

            team1.addOversPlay();
            // Strike change every over
            ArrayList<Player> newPositionOfBatsman=  StrikeChange(batsman1,batsman2);
            batsman1 = newPositionOfBatsman.get(0);
            batsman2 = newPositionOfBatsman.get(1);
        }
        return team1.getScore();
    }

    private int RandomFunction()
    {
        int num = (int)(Math.random()*150);

        if(num > 140) return wicketNumber;
        else if(num > 130) return six;
        else if(num > 100) return four;
        else return (int)(Math.random()*5);
    }
    private ArrayList<Player> StrikeChange(Player batsman1, Player batsman2) {
        ArrayList<Player> p =  new ArrayList<Player> ();
        p.add(batsman2);
        p.add(batsman1);

        return p;
    }
    private ArrayList<String> printScoreBord(Team team1, Team team2) {

        ArrayList<String> scoreBoard = new ArrayList<>();

        // 1st inning
        ArrayList<String> team1BattingDetail = scoreBord.PrintScoreBordOfBattingTeam(team1);
        scoreBoard.addAll(team1BattingDetail);

        ArrayList<String> team2BowlingDetail = scoreBord.PrintScoreBordOfBowlingTeam(team2);
        scoreBoard.addAll(team2BowlingDetail);

        ArrayList<String> inning1BallDetail = scoreBord.GetDetailOfBall(team1);
        scoreBoard.addAll(inning1BallDetail);

        // 2nd inning
        ArrayList<String> team2BattingDetail = scoreBord.PrintScoreBordOfBattingTeam(team2);
        scoreBoard.addAll(team2BattingDetail);

        ArrayList<String> team1BowlingDetail = scoreBord.PrintScoreBordOfBowlingTeam(team1);
        scoreBoard.addAll(team1BowlingDetail);

        ArrayList<String> inning2BallDetail = scoreBord.GetDetailOfBall(team2);
        scoreBoard.addAll(inning2BallDetail);

        return scoreBoard;
    }
}
