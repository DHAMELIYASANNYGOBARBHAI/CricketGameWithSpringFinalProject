package com.example.CricketGameWithSpring.dao;

import com.example.CricketGameWithSpring.entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamDetailDao extends JpaRepository<TeamDetail, Integer> {

    @Query(value = "SELECT * FROM team p WHERE p.team_name = :teamName", nativeQuery = true)
    public List<TeamDetail> findTeamDetailByTeamName(String teamName);
}
