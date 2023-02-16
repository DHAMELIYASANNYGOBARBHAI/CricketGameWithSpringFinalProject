package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.MatchDetails;
import com.example.CricketGameWithSpring.Entity.MatchInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchInfoDao extends MongoRepository<MatchInfo, Integer>
{
    Optional<MatchInfo> findFirstByOrderByIdDesc();
}
