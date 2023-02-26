package com.example.CricketGameWithSpring.Service;

import com.example.CricketGameWithSpring.Entity.TeamDetail;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeamDetailService {
    public List<TeamDetail> getTeamDetailByTeamName(String teamName);

}
