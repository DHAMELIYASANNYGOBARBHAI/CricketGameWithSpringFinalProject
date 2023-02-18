package com.example.CricketGameWithSpring.Entity;


import jakarta.persistence.Entity;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class MatchDetails
{
   private String team1Name;
   private String team2Name;
   private int overs;
   List<Integer> team1PlayerId;
   List<Integer>team2PlayerId;
}
