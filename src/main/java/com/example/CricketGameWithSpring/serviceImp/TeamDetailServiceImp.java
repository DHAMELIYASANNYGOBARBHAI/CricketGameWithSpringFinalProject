package com.example.CricketGameWithSpring.serviceImp;

import com.example.CricketGameWithSpring.dao.TeamDetailDao;
import com.example.CricketGameWithSpring.entity.TeamDetail;
import com.example.CricketGameWithSpring.service.TeamDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeamDetailServiceImp implements TeamDetailService {

    @Autowired
    private TeamDetailDao teamDetailDao;

    @Override
    public List<TeamDetail> getTeamDetailByTeamName(String teamName) {
        return teamDetailDao.findTeamDetailByTeamName(teamName);
    }
}
