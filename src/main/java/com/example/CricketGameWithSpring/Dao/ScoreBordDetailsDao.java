package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.ScoreBordDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableMongoRepositories
public interface ScoreBordDetailsDao extends MongoRepository<ScoreBordDetail,Integer>{
    ScoreBordDetail findBymatchID(int matchId);
    @Query("{ $or: [ { 'team1Name': ?0 }, { 'team2Name': ?0 } ] }")
    List<ScoreBordDetail> findScoreBordDetailOfMatchUsingTeam(String teamName1);
}
