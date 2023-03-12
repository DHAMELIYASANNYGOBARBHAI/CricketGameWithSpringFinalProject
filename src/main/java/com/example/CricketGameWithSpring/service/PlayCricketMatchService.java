package com.example.CricketGameWithSpring.service;

import com.example.CricketGameWithSpring.entity.Team;


public interface PlayCricketMatchService {

    public int playCricketMatchBetweenTwoTeam(Team battingTeam, Team bowlingTeam, int Overs);


}
