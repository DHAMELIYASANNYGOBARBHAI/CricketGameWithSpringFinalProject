package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Entity.MatchInfo;
import com.example.CricketGameWithSpring.Entity.ScoreBordDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchInfoDao extends MongoRepository<MatchInfo, Integer> {
    Optional<MatchInfo> findFirstByOrderByIdDesc();
    MatchInfo findById(int matchId);
    @Query("{ $or: [ { 'team1Name': ?0 }, { 'team2Name': ?0 } ] }")
    List<MatchInfo> findMatchInfoOfMatchUsingTeam(String teamName);
}
