package com.example.CricketGameWithSpring.Entity;


//import jakarta.persistence.Entity;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.ArrayList;


@Data
public class MatchDetails
{


   private String team1Name;
   private String team2Name;
   private  int Overs;

  ArrayList<Player> team1;
  ArrayList<Player> team2;

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public void setOvers(int overs) {
        Overs = overs;
    }

    public void setTeam1(ArrayList<Player> team1) {
        this.team1 = team1;
    }

    public void setTeam2(ArrayList<Player> team2) {
        this.team2 = team2;
    }

    public String getTeam1Name() {
      return team1Name;
   }

   public String getTeam2Name() {
      return team2Name;
   }

   public int getOvers() {
      return Overs;
   }

   public ArrayList<Player> getTeam1() {
      return team1;
   }

   public ArrayList<Player> getTeam2() {
      return team2;
   }
}
