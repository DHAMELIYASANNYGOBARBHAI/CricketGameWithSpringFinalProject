package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.Player;
import com.example.CricketGameWithSpring.Entity.PlayerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerInfoDao extends JpaRepository<PlayerInfo, Integer> {
    @Query(value = "SELECT COUNT(*) FROM player_info WHERE player_info.player_id = :playerId",nativeQuery = true)
    int countById(@Param("playerId") int playerId);
    @Query(value = "SELECT player_name FROM player_info p WHERE p.player_id = :playerId",nativeQuery = true)
    String findNameById(@Param("playerId") int playerId);
    @Query(value = "SELECT player_role FROM player_info p WHERE p.player_id = :playerId",nativeQuery = true)
    String findRoleById(@Param("playerId") int playerId);
    @Query(value = "SELECT * FROM player_info p WHERE p.player_role = :playerRole",nativeQuery = true)
    List<PlayerInfo> findByRole(String playerRole);
}
