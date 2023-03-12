package com.example.CricketGameWithSpring.dao;

import com.example.CricketGameWithSpring.entity.HistoryOfMatch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryOfMatchDao extends MongoRepository<HistoryOfMatch, Integer> {

    public HistoryOfMatch findByMatchId(int matchId);
}
