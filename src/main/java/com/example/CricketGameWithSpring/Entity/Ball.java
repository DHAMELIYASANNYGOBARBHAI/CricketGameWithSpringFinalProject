package com.example.CricketGameWithSpring.Entity;

public class Ball
{
    private int OverNo;
    private int SerialNoOfBall;
    private String NameOfBatsman;
    private String NameOfBowler;
    private int Runs;
    private Boolean IsWicket;

    public Ball() {
        OverNo = 0;
        SerialNoOfBall = 0;
        NameOfBatsman = "";
        NameOfBowler = "";
        Runs = 0;
        IsWicket = false;
    }

    public Ball(int overNo, int serialOfBall, String nameOfBatsman, String nameOfBowler, int runs,boolean isWicket)
    {
        OverNo = overNo;
        SerialNoOfBall = serialOfBall;
        NameOfBatsman = nameOfBatsman;
        NameOfBowler = nameOfBowler;
        Runs = runs;
        IsWicket = isWicket;
    }

    public int getOverNo() {
        return OverNo;
    }

    public int getSerialNoOfBall() {
        return SerialNoOfBall;
    }

    public String getNameOfBatsman() {
        return NameOfBatsman;
    }

    public String getNameOfBowler() {
        return NameOfBowler;
    }

    public int getRuns() {
        return Runs;
    }

    public Boolean getWicket() {
        return IsWicket;
    }
}
