package com.example.CricketGameWithSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CricketGameWithSpringApplication {

	public static void main(String[] args)
	{
		try {
			SpringApplication.run(CricketGameWithSpringApplication.class, args);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}



}


//{
//		"team1Name" :  "india",
//		"team2Name" : "pak",
//		"Overs" : 20,
//		"team1PlayerId" : [1,2,3,4,5,6,7,11,12,13,14,8989],
//		"team2PlayerId" : [8,9,10,15,16,17,18,19,28,21,22]
//
//		}