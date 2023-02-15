package com.example.CricketGameWithSpring.Entity;

//import jakarta.persistence.Entity;


public class Player
{

    private String Name;
    private String Role;
    private int RunScoredByPlayer;
    private int BallsFacedByPlayer;
    private int WicketTakenByPlayer;
    private int BallBowledByPlayer;
    private int RunConsiderByPlayer;
    public Player()
    {

    }

    public void setRole(String role) {
        Role = role;
    }

    public Player(String name, String role)
    {
        Name = name;
        Role = role;
        RunScoredByPlayer = 0;
        BallsFacedByPlayer = 0;
        WicketTakenByPlayer = 0;
        BallBowledByPlayer = 0;
        RunScoredByPlayer = 0;
    }

    public void setName(String name) {
        Name = name;
    }



    public String getName() {
        return Name;
    }

    public String getRole() {
        return Role;
    }

    public int getRunScoredByPlayer() {
        return RunScoredByPlayer;
    }

    public int getBallsFacedByPlayer() {
        return BallsFacedByPlayer;
    }

    public int getWicketTakenByPlayer() {
        return WicketTakenByPlayer;
    }

    public int getBallBowledByPlayer() {
        return BallBowledByPlayer;
    }

    public int getRunConsiderByPlayer() {
        return RunConsiderByPlayer;
    }


    public void addRunByPlayer(int Run)
    {
        RunScoredByPlayer += Run;
        BallsFacedByPlayer++;
    }


    public void addBallAtWicketDown()
    {
        BallsFacedByPlayer++;
    }

    public void addRunConsiderByPlayer(int Run)
    {
        RunConsiderByPlayer +=Run;
        BallBowledByPlayer++;
    }
    public void addWicketByPlayer()
    {
        WicketTakenByPlayer++;
        BallBowledByPlayer++;

    }

}
