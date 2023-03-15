package com.example.CricketGameWithSpring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ball {

    private int overNoOfBall;
    private int serialNoOfBall;
    private String nameOfBatsmanWhoPlayBall;
    private String nameOfBowlerWhoBowledBall;
    private int runsCoveredOnBall;
    private String typeOfBall;

}
