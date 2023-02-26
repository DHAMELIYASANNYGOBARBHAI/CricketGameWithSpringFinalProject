package com.example.CricketGameWithSpring.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ball
{
    private int overNoOfBall;
    private int serialNoOfBall;
    private String nameOfBatsmanWhoPlayBall;
    private String nameOfBowlerWhoBowledBall;
    private int runsCoveredOnBall ;
    private String typeOfBall;

}
