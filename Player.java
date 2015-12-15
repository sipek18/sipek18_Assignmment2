package com.example.kelson.footballfantasy;

import java.io.Serializable;

/**
 * @author Kelson Sipe
 *
 * @version  09/290/2015
 */

public class Player implements Serializable {

    private String playerName;
    private int goals;
    private int shotsOnGoal;
    private int assists;
    private int saves;
    private int fouls;
    private int yellowCards;
    private int redCards;

    private String imageID;


    protected Player(String name, int goalsStat, int shotsOnGoalStat, int assistsStat, int savesStat, int foulsStat, int yellowCardsStat, int redCardsStat){
        this.playerName = name;
        this.goals = goalsStat;
        this.shotsOnGoal = shotsOnGoalStat;
        this.assists = assistsStat;
        this.saves = savesStat;
        this.fouls = foulsStat;
        this.yellowCards = yellowCardsStat;
        this.redCards = redCardsStat;

        this.setImageID("snow_leopard");
    }

    public int setPlayerName(String name){
        try{
            this.playerName = name;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public String getPlayerName(){
        return this.playerName;
    }

    public int setGoals(int goalsStat){
        try{
            this.goals = goalsStat;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public int getGoals(){
        return this.goals;
    }

    public int setShotsOnGoal(int shotsOnGoalStat){
        try{
            this.shotsOnGoal = shotsOnGoalStat;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public int getShotsOnGoal(){
        return this.shotsOnGoal;
    }

    public int setAssists(int assistsStat){
        try{
            this.assists = assistsStat;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public int getAssists(){
        return this.assists;
    }

    public int setSaves(int savesStat){
        try{
            this.saves = savesStat;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public int getSaves(){
        return this.saves;
    }

    public int setFouls(int foulsStat){
        try{
            this.fouls = foulsStat;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public int getFouls(){
        return this.fouls;
    }

    public int setYellowCards(int yellowCardsStat){
        try{
            this.yellowCards = yellowCardsStat;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public int getYellowCards(){
        return this.yellowCards;
    }

    public int setRedCards(int redCardsStat){
        try{
            this.redCards = redCardsStat;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public int getRedCards(){
        return this.redCards;
    }

    public int setImageID(String imageName){
        try{
            this.imageID = imageName;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public String getImageID(){
        return this.imageID;
    }


}
