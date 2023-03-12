package com.example.CricketGameWithSpring.ServiceImp;

import com.example.CricketGameWithSpring.Dao.TeamDetailDao;
import com.example.CricketGameWithSpring.Entity.TeamDetail;
import com.example.CricketGameWithSpring.Service.TeamDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeamDetailServiceImp implements TeamDetailService
{
    @Autowired
    private TeamDetailDao teamDetailDao;
    @Override
    public List<TeamDetail> getTeamDetailByTeamName(String teamName) {return teamDetailDao.findTeamDetailByTeamName(teamName);}
}
