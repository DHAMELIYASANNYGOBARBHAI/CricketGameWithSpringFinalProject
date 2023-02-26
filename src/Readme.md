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