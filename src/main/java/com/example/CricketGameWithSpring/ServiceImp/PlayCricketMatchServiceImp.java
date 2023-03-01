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
    public int playCricketMatchBetweenTwoTeam(Team battingTeam,Team bowlingTeam ,int Overs){

            int batsmanNo = 0;
            int lastBowlerNo = -1;

            Player batsman1 = battingTeam.getBatsman(batsmanNo++); // on strike
            Player batsman2 = battingTeam.getBatsman(batsmanNo++); // off side

            for(int i=0;i<Overs;i++)
            {

                int NextBowlerNo = bowlingTeam.getNextBowlerNo(lastBowlerNo);
                Player Bowler = bowlingTeam.getBowler(NextBowlerNo);
                lastBowlerNo = NextBowlerNo;

                for(int j=0;j<numOfBallInOver;j++)
                {
                    int run = RandomFunction();

                    if(run==wicket)
                    {
                        // consider as wicket for Now
                        Ball ball = new Ball(i,j,batsman1.getPlayerName(),Bowler.getPlayerName(),0,"WicketDown");
                        Bowler.addWicketByPlayer();
                        batsman1.addBallAtWicketDown();
                        battingTeam.addBallDetails(ball);
                        battingTeam.addWicketLoss();
                        if(battingTeam.getWicketLossOfTeam() == lastWicket) {return battingTeam.getScoreOfTeam();}
                        batsman1 = battingTeam.getBatsman(batsmanNo++);
                    }
                    else
                    {
                        // 0,1,2,3,4,5,6
                        Ball ball = new Ball(i,j,batsman1.getPlayerName(),Bowler.getPlayerName(),run,Integer.toString(run)+" Run gained On this Ball");
                        batsman1.addRunByPlayer(run);
                        Bowler.addRunConsiderByPlayer(run);
                        battingTeam.addScore(run);
                        battingTeam.addBallDetails(ball);
                        if((run%2) == 1) {
                            // Strike change  by batsman at run : 1,3,5
                            List<Player> newPositionOfBatsman=  StrikeChange(batsman1,batsman2);
                            batsman1 = newPositionOfBatsman.get(0);
                            batsman2 = newPositionOfBatsman.get(1);
                        }


                    }


                }

                battingTeam.addOversPlay();
                // Strike change every over
                List<Player> newPositionOfBatsman =  StrikeChange(batsman1,batsman2);
                batsman1 = newPositionOfBatsman.get(0);
                batsman2 = newPositionOfBatsman.get(1);
            }

            return battingTeam.getScoreOfTeam();

    }

    public int RandomFunction(){
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
