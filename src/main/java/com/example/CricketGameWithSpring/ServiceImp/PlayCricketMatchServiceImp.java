package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Entity.Ball;
import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.Team;
import com.example.CricketGameWithSpring.Service.PlayCricketMatchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayCricketMatchServiceImp implements PlayCricketMatchService {

    public static final int numOfBallInOver = 6;
    public static final int wicket = 7;
    public static final int lastWicket = 10;
    public static final int six = 6;
    public static final int four = 4;

    @Override
    public int playCricketMatchBetweenTwoTeam(Team battingTeam,Team bowlingTeam ,int overs){

            int batsmanNo = 0;
            int lastBowlerNo = -1;

            Player strikerBatsman = battingTeam.getBatsman(batsmanNo++); // on strike
            Player onStrikerBatsman = battingTeam.getBatsman(batsmanNo++); // off side

            for(int i=0;i<overs;i++)
            {

                int NextBowlerNo = bowlingTeam.getNextBowlerNo(lastBowlerNo);
                Player bowler = bowlingTeam.getBowler(NextBowlerNo);
                lastBowlerNo = NextBowlerNo;

                for(int j=0;j<numOfBallInOver;j++)
                {
                    int run = randomRunOrWicketGeneratorOnEveryBall()  ;

                    if(run==wicket)
                    {
                        // consider as wicket for Now
                        Ball ball = new Ball(i,j,strikerBatsman.getPlayerName(),bowler.getPlayerName(),0,"WicketDown");
                        bowler.addWicketByPlayer();
                        strikerBatsman.addBallAtWicketDown();
                        battingTeam.addBallDetails(ball);
                        battingTeam.addWicketLoss();
                        if(battingTeam.getWicketLossOfTeam() == lastWicket) {return battingTeam.getScoreOfTeam();}
                        strikerBatsman = battingTeam.getBatsman(batsmanNo++);
                    }
                    else
                    {
                        // 0,1,2,3,4,5,6
                        Ball ball = new Ball(i,j,strikerBatsman.getPlayerName(),bowler.getPlayerName(),run,Integer.toString(run)+" Run gained On this Ball");
                        strikerBatsman.addRunByPlayer(run);
                        bowler.addRunConsiderByPlayer(run);
                        battingTeam.addScore(run);
                        battingTeam.addBallDetails(ball);
                        if((run%2) == 1) {
                            // Strike change  by batsman at run : 1,3,5  here we can use this also --->  Player tempPlayer = strikerBatsman;strikerBatsman = batsman2;batsman2 = tempPlayer;
                            List<Player> newPositionOfBatsman=  StrikeChange(strikerBatsman,onStrikerBatsman);
                            strikerBatsman = newPositionOfBatsman.get(0);
                            onStrikerBatsman = newPositionOfBatsman.get(1);
                        }

                    }
                }

                battingTeam.addOversPlay();
                // Strike change every over
                List<Player> newPositionOfBatsman =  StrikeChange(strikerBatsman,onStrikerBatsman);
                strikerBatsman = newPositionOfBatsman.get(0);
                onStrikerBatsman = newPositionOfBatsman.get(1);
            }

            return battingTeam.getScoreOfTeam();

    }

    public int randomRunOrWicketGeneratorOnEveryBall(){
        int num = (int)(Math.random()*150);
        if(num > 140) return wicket;
        else if(num > 130) return six;
        else if(num > 100) return four;
        else return (int)(Math.random()*5);
    }

    public List<Player> StrikeChange(Player batsman1, Player batsman2) {
        List<Player> p =  new ArrayList<Player>();
        p.add(batsman2);
        p.add(batsman1);
        return p;
    }
}
