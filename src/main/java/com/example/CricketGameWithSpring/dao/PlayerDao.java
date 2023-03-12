package com.example.CricketGameWithSpring.dao;

import com.example.CricketGameWithSpring.entity.Player;
import com.example.CricketGameWithSpring.entity.PlayerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDao extends JpaRepository<Player, PlayerId> {

    @Query(value = "SELECT * FROM player_info_at_every_match p WHERE p.player_name = :playerName", nativeQuery = true)
    public List<Player> findByName(String playerName);

}


