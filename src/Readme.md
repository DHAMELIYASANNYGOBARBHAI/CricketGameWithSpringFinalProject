#Mongodb:
brew services start mongodb-community@6.0  ---> mongo db start (server)
brew services stop mongodb-community@6.0   ---> stopping mongodb
command:---------->
show databases;  
use CricketMatchDetails;
show collections;
db.HistoryOfCricketMatch.find();
db.ScoreBordDetail.drop();




#mysql:
first start my sql server then -->
/usr/local/mysql/bin/mysql -u root -p     ---> my sql start
command:---------->
show databases;
use CricketMatch
show tables;
select * from player;
DROP TABLE player_info;
SHOW INDEXES FROM player_info;

#elasticserch
Downloads --> elasticsearch-8.6.2  --> bin/elasticsearch
Downloads ---> kibana-8.6.2 ---> bin/kibana
http://localhost:9200/   --->server
http://localhost:5601/   ---> kibana
command: --->
GET players_all_detail/_search
DELETE /players_all_detail




1. String Match Between two Team 

    @PostMapping("/StartMatch")

   Given this below Input in (Body -> row -> Json)
   {
        "team1Name" :  "india",
        "team2Name" : "pak",
        "Overs" : 20,
        "team1PlayerId" : [1,2,3,4,5,6,7,11,12,13,14],
        "team2PlayerId" : [8,9,10,15,16,17,18,19,28,21,22]

     }

2. Find historyOfMatchDetail using MatchId 
   @GetMapping("/historyOfMatchDetail/{matchId}") 

3. Find ScoreBordImp using MatchId
   @GetMapping("/MatchDetail/ScoreBordImp/{matchId}") //ScoreBordDetail