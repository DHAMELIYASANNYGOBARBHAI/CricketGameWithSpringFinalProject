package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.HistoryOfCricketMatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface HistoryOfCricketMatchDao extends MongoRepository<HistoryOfCricketMatch, Integer>
{
    HistoryOfCricketMatch findBymatchId(int matchId);
}
