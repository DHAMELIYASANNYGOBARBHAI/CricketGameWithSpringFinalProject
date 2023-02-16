package com.example.CricketGameWithSpring.Dao;

import com.example.CricketGameWithSpring.Entity.PlayerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerInfoDao extends JpaRepository<PlayerInfo, Integer>
{
   // @Query(value = "select max(matchdemo.id) from matchdemo",nativeQuery = true)
    @Query(value = "SELECT COUNT(*) FROM PlayerInfo WHERE PlayerInfo.player_id = :playerId",nativeQuery = true)
    int countById(@Param("playerId") int playerId);

    @Query(value = "SELECT player_name FROM PlayerInfo p WHERE p.player_id = :playerId",nativeQuery = true)
    String findNameById(@Param("playerId") int playerId);

    @Query(value = "SELECT player_role FROM PlayerInfo p WHERE p.player_id = :playerId",nativeQuery = true)
    String findRoleById(@Param("playerId") int playerId);



}
