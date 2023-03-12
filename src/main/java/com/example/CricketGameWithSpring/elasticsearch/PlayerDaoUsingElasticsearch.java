package com.example.CricketGameWithSpring.elasticsearch;


import com.example.CricketGameWithSpring.entity.PlayersAllDetail;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDaoUsingElasticsearch extends ElasticsearchRepository<PlayersAllDetail, Long> {

    public List<PlayersAllDetail> findByPlayerName(String playerName);
}
