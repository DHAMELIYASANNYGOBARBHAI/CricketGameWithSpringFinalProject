package com.example.CricketGameWithSpring.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.CricketGameWithSpring.Entity.*;
import com.example.CricketGameWithSpring.Service.*;
import com.example.CricketGameWithSpring.ServiceImp.MatchServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
@ExtendWith(MockitoExtension.class)
class MyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    public CricketService cricketService;
    @MockBean
    public ScoreBordDetailService scoreBordDetailService;
    @MockBean
    public MatchInfoService matchInfoService;
    @MockBean
    HistoryOfMatchService historyOfMatchService;
    @MockBean
    PlayerInfoService playerInfoService;
    @MockBean
    PlayerService playerService;
    @MockBean
    TeamDetailService teamDetailService;
    @InjectMocks
    private MyController myController;
    @BeforeEach
    void setUp() {
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    void startMatch() throws Exception {
        List<String> scoreBordDetailOfCricketMatch = new ArrayList<>();
        scoreBordDetailOfCricketMatch.add("random text1");
        scoreBordDetailOfCricketMatch.add("random text2");
        when(cricketService.startGame(new MatchDetails())).thenReturn(scoreBordDetailOfCricketMatch);
        String expectedJson = objectMapper.writeValueAsString(scoreBordDetailOfCricketMatch);
        mockMvc.perform(MockMvcRequestBuilders.post("/startMatch")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new MatchDetails())))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }
    @Test
    void getScoreBordDetailOfMatch() throws Exception {

        ScoreBordDetail scoreBordDetail = new ScoreBordDetail(100,"indiaTeam",200,8,20,"pakistanTeam",255,7,20);
        when(scoreBordDetailService.getScoreBordDetailOfMatch(100)).thenReturn(scoreBordDetail);

        mockMvc.perform(MockMvcRequestBuilders.get("/matchDetail/scoreBordImp/100"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.matchID").value(scoreBordDetail.getMatchID()))
                .andExpect(jsonPath("$.team1Name").value(scoreBordDetail.getTeam1Name()))
                .andExpect(jsonPath("$.scoreOfTeam1").value(scoreBordDetail.getScoreOfTeam1()))
                .andExpect(jsonPath("$.wicketLossOfTeam1").value(scoreBordDetail.getWicketLossOfTeam1()))
                .andExpect(jsonPath("$.oversPlayByTeam1").value(scoreBordDetail.getOversPlayByTeam1()))
                .andExpect(jsonPath("$.team2Name").value(scoreBordDetail.getTeam2Name()))
                .andExpect(jsonPath("$.scoreOfTeam2").value(scoreBordDetail.getScoreOfTeam2()))
                .andExpect(jsonPath("$.wicketLossOfTeam2").value(scoreBordDetail.getWicketLossOfTeam2()))
                .andExpect(jsonPath("$.oversPlayByTeam2").value(scoreBordDetail.getOversPlayByTeam2()));


    }

    @Test
    void getScoreBordDetailOfMatchUsingTeam() throws Exception{

        List<ScoreBordDetail> scoreBordDetails = new ArrayList<>();
        // Add some ScoreBordDetail objects to the list
        scoreBordDetails.add(new ScoreBordDetail(100,"indiaTeam",200,8,20,"pakistanTeam",255,7,20));
        scoreBordDetails.add(new ScoreBordDetail(102,"indiaTeam",180,9,20,"southAfricaTeam",170,7,20));
        when(scoreBordDetailService.getScoreBordDetailOfMatchUsingTeam("indiaTeam")).thenReturn(scoreBordDetails);
        String expectedJson = objectMapper.writeValueAsString(scoreBordDetails);
        mockMvc.perform(MockMvcRequestBuilders.get("/matchDetail/scoreBordDetailUsingTeam/indiaTeam"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }


    @Test
    void getMatchInfoOfMatch() throws Exception{

       MatchInfo matchInfo = new MatchInfo(100,"India","Pakistan","India","Pakistan");
       when(matchInfoService.getMatchInfoOfMatch(100)).thenReturn(matchInfo);
       String expectedJson = objectMapper.writeValueAsString(matchInfo);
       mockMvc.perform(MockMvcRequestBuilders.get("/matchDetail/matchInfo/100"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    void getMatchInfoOfMatchUsingTeam() throws Exception {

        List<MatchInfo> matchInfos= new ArrayList<>();
        // Add some ScoreBordDetail objects to the list
        matchInfos.add(new MatchInfo(100,"India","Pakistan","India","Pakistan"));
        matchInfos.add(new MatchInfo(101,"India","Pakistan","India","India"));
        when(matchInfoService.getMatchInfoOfMatchUsingTeam("Pakistan")).thenReturn(matchInfos);
        String expectedJson = objectMapper.writeValueAsString(matchInfos);
        mockMvc.perform(MockMvcRequestBuilders.get("/matchDetail/matchInfoUsingTeam/Pakistan"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }
    @Test
    void getPlayerByPlayerName() throws Exception {
        List<Player> players = new ArrayList<>();
        players.add(new Player(100L,"player1","All-Rounder","India",100,70,10,2,21,30));
        players.add(new Player(100L,"player1","All-Rounder","India",101,60,10,4,21,30));
        when(playerService.getPlayerByPlayerName("player1")).thenReturn(players);
        String expectedJson = objectMapper.writeValueAsString(players);
        mockMvc.perform(MockMvcRequestBuilders.get("/matchDetail/player/player1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));

    }
    @Test
    void getPlayerInfoByPlayerRole() throws Exception {
        List<PlayerInfo> playerInfos = new ArrayList<>();
        playerInfos.add(new PlayerInfo(100,"player100","All-Rounder"));
        playerInfos.add(new PlayerInfo(101,"player101","All-Rounder"));
        when(playerInfoService.getPlayerInfoByPlayerRole("All-Rounder")).thenReturn(playerInfos);
        String expectedJson = objectMapper.writeValueAsString(playerInfos);
        mockMvc.perform(MockMvcRequestBuilders.get("/matchDetail/playerInfo/All-Rounder"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }
    @Test
    void getTeamDetailByTeamName() throws Exception {

        List<TeamDetail> teamDetails = new ArrayList<>();
        teamDetails.add(new TeamDetail(100,1,"RR",100,8,20));
        teamDetails.add(new TeamDetail(101,4,"RR",150,5,20));
        when(teamDetailService.getTeamDetailByTeamName("RR")).thenReturn(teamDetails);
        String expectedJson = objectMapper.writeValueAsString(teamDetails);
        mockMvc.perform(MockMvcRequestBuilders.get("/matchDetail/teamDetail/RR"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    void getMatchDetails() throws Exception{

        List<String> scoreBordDetailOfCricketMatch = new ArrayList<>();
        scoreBordDetailOfCricketMatch.add("random text");
        scoreBordDetailOfCricketMatch.add("random text2");

        HistoryOfMatch historyOfMatch = new HistoryOfMatch(100,scoreBordDetailOfCricketMatch);
        when(historyOfMatchService.getMatchDetails(100)).thenReturn(historyOfMatch);
        String expectedJson = objectMapper.writeValueAsString(historyOfMatch);
        mockMvc.perform(MockMvcRequestBuilders.get("/historyOfMatchDetail/100"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }
}