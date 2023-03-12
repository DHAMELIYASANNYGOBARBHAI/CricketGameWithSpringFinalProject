package com.example.CricketGameWithSpring.dao;

import com.example.CricketGameWithSpring.entity.ScoreBordDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableMongoRepositories
public interface ScoreBordDetailsDao extends MongoRepository<ScoreBordDetail, Integer> {

    public ScoreBordDetail findBymatchID(int matchId);

    @Query("{ $or: [ { 'team1Name': ?0 }, { 'team2Name': ?0 } ] }")
    public List<ScoreBordDetail> findScoreBordDetailOfMatchUsingTeam(String teamName1);
}
