package com.example.CricketGameWithSpring.dao;

import com.example.CricketGameWithSpring.entity.MatchInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableMongoRepositories
public interface MatchInfoDao extends MongoRepository<MatchInfo, Integer> {

    public Optional<MatchInfo> findFirstByOrderByIdDesc();

    public MatchInfo findById(int matchId);

    @Query("{ $or: [ { 'team1Name': ?0 }, { 'team2Name': ?0 } ] }")
    public List<MatchInfo> findMatchInfoOfMatchUsingTeam(String teamName);
}
