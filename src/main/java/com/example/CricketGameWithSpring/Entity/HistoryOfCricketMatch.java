package com.example.CricketGameWithSpring.Entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "HistoryOfCricketMatch")
public class HistoryOfCricketMatch
{
   @Id
   private int matchId;
   private List<String> scoreBordDetailOfCricketMatch;
}
