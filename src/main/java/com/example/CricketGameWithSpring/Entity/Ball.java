package com.example.CricketGameWithSpring.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ball
{
    private int OverNo;
    private int SerialNoOfBall;
    private String NameOfBatsman;
    private String NameOfBowler;
    private int Runs;
    private Boolean IsWicket;

}
