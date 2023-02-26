package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamDetailDao extends JpaRepository<TeamDetail,Integer>{
    @Query(value = "SELECT * FROM team p WHERE p.team_name = :teamName",nativeQuery = true)
    List<TeamDetail> findTeamDetailByTeamName(String teamName);
}
