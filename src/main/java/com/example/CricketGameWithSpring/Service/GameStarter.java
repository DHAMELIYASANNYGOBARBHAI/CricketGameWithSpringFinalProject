package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.Team;

import java.util.ArrayList;

public class GameStarter
{
    public ArrayList<String> start() {
        Match match = new Match(getTeam1(),getTeam2(),getOvers()); // take three input : team1 player,team2 player, how may overs
        return match.startGame();

    }

    public ArrayList<String> start(MatchDetails matchDetails)
    {
       Match match = new Match(getTeam1(matchDetails.getTeam1Name(),matchDetails.getTeam1()),getTeam2(matchDetails.getTeam2Name(),matchDetails.getTeam2()),getOvers());
        //System.out.println(matchDetails.getOvers());
        return match.startGame();
    }



    private Team getTeam2(String team2Name, ArrayList<Player> team2)
    {
        Team team = new Team(team2Name, team2);
        return team;
    }




    private Team getTeam1(String team1Name, ArrayList<Player> team1)
    {
        Team team = new Team(team1Name, team1);
        return team;
    }




    private Team getTeam1() {
        Team team = new Team("India", getPlayersOfTeam1());
        return team;
    }

    private ArrayList<Player> getPlayersOfTeam1() {

        ArrayList<Player>  playersOfTeam1 = new ArrayList<Player>();

        for(int i=0;i<11;i++) {
            playersOfTeam1.add(new Player());
            playersOfTeam1.get(i).setRole("Batsman");
        }

        playersOfTeam1.get(0).setName("Sachin Tendulkar");
        playersOfTeam1.get(1).setName("MS Dhoni");
        playersOfTeam1.get(2).setName("Gautam Gambhir");
        playersOfTeam1.get(3).setName("Virat Kohli");
        playersOfTeam1.get(4).setName("Yuvraj Singh");
        playersOfTeam1.get(5).setName("Suresh Raina");
        playersOfTeam1.get(6).setName("Harbhajan Singh");
        playersOfTeam1.get(7).setName("Ashish Nehra");
        playersOfTeam1.get(8).setName("Yusuf Pathan");
        playersOfTeam1.get(9).setName("Virender Sehwag");
        playersOfTeam1.get(10).setName("Ravich Ashwin");

        playersOfTeam1.get(4).setRole("Bowler");
        playersOfTeam1.get(5).setRole("Bowler");
        playersOfTeam1.get(7).setRole("Bowler");
        playersOfTeam1.get(10).setRole("Bowler");

        return playersOfTeam1;
    }

    private int getOvers()
    {
        int Overs=20;
        return Overs;
    }



    private Team getTeam2()
    {
        Team team = new Team("Pakistan", getPlayersOfTeam2());
        return team;
    }



    private ArrayList<Player>  getPlayersOfTeam2()
    {
        ArrayList<Player>  playersOfTeam2 = new ArrayList<Player>();

        for(int i=0;i<11;i++)
        {
            playersOfTeam2.add(new Player());
            playersOfTeam2.get(i).setRole("Batsman");
        }

        playersOfTeam2.get(0).setName("Junaid Khan");
        playersOfTeam2.get(1).setName("Asad Shafiq");
        playersOfTeam2.get(2).setName("Wahab Riaz");
        playersOfTeam2.get(3).setName("Umar Gul");
        playersOfTeam2.get(4).setName("Sohail Tanvir");
        playersOfTeam2.get(5).setName("Saeed Ajmal");
        playersOfTeam2.get(6).setName("Abdul Razzaq");
        playersOfTeam2.get(7).setName("Abdur Rehman");
        playersOfTeam2.get(8).setName("Azhar Ali");
        playersOfTeam2.get(9).setName("Umar Akmal");
        playersOfTeam2.get(10).setName("Younis Khan");

        playersOfTeam2.get(3).setRole("Bowler");
        playersOfTeam2.get(4).setRole("Bowler");
        playersOfTeam2.get(8).setRole("Bowler");
        playersOfTeam2.get(9).setRole("Bowler");

        return playersOfTeam2;

    }

}
