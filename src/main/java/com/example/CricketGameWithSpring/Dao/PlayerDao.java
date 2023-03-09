package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerDao extends JpaRepository<Player,Long>{
    @Query(value = "SELECT * FROM Player p WHERE p.player_name = :playerName",nativeQuery = true)
    List<Player> findByName(String playerName);

    @Query(value = "SELECT * FROM Player p ORDER BY p.player_id DESC LIMIT 1", nativeQuery = true)
    Player findFirstByOrderByIdDesc();
}


