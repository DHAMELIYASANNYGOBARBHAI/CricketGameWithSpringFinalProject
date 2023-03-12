package com.example.CricketGameWithSpring.service;

import com.example.CricketGameWithSpring.entity.TeamDetail;

import java.util.List;


public interface TeamDetailService {

    public List<TeamDetail> getTeamDetailByTeamName(String teamName);

}
