package com.example.CricketGameWithSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CricketGameWithSpringApplication {
	public static void main(String[] args) {
		try {SpringApplication.run(CricketGameWithSpringApplication.class, args);}
		catch (Exception ex){ex.printStackTrace();}
	}
}

