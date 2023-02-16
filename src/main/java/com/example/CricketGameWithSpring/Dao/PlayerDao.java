package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao extends JpaRepository<Player,Long>
{

}


