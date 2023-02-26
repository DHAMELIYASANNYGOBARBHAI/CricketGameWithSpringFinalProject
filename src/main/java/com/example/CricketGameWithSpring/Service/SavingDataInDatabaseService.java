package com.example.CricketGameWithSpring.Service;

import org.springframework.stereotype.Service;

import java.util.List;


public interface SavingDataInDatabaseService {
    public void savingCricketMatchRelatedDataInDatabase(MatchServiceImp matchServiceImp);
}
