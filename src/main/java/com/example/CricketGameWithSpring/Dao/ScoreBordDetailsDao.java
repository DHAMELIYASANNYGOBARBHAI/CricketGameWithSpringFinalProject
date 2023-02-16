package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.ScoreBordDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScoreBordDetailsDao extends MongoRepository<ScoreBordDetail,Integer>
{

}
