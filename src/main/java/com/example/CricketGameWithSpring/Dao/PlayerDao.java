package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.PlayerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerDao extends JpaRepository<Player, PlayerId>
{

    @Query(value = "SELECT * FROM PlayerInfoAtEveryMatch p WHERE p.player_name = :playerName",nativeQuery = true)
    public List<Player> findByName(String playerName);

    @Query(value = "SELECT * FROM PlayerInfoAtEveryMatch p ORDER BY p.player_id DESC LIMIT 1", nativeQuery = true)
    public Player findFirstByOrderByIdDesc();

}


