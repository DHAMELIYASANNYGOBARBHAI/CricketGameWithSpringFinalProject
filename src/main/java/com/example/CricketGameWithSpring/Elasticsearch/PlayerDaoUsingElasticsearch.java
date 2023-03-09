package com.example.CricketGameWithSpring.Elasticsearch;


import com.example.CricketGameWithSpring.Entity.PlayersAllDetail;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDaoUsingElasticsearch extends ElasticsearchRepository<PlayersAllDetail,Long>
{
    List<PlayersAllDetail> findByPlayerName(String playerName);
}
