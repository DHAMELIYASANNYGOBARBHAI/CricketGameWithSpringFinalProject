package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.Team;
import com.example.CricketGameWithSpring.Entity.TeamDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<TeamDetail,Integer>
{

}
