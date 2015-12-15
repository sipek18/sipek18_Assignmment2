package com.example.kelson.footballfantasy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Kelson Sipe
 *
 * @version  09/29/2015
 */

public class Team implements Serializable {

    private String teamName;
    private int gameWins;
    private int gameLoses;
    private String imageID;
    public ArrayList<String> playerList;
    private HashMap<String,Player> teamList;

    protected Team(String name, int gamesWon, int gamesLost){

        if(gamesWon < 0)
            gamesWon = 0;
        this.gameWins = gamesWon;
        if(gamesLost < 0)
            gamesLost = 0;
        this.gameLoses = gamesLost;

        this.teamName = name;
        this.setImageID("snow_leopard");
        playerList = new ArrayList<String>();
        teamList = new HashMap<String,Player>();


        Player snowCat = new Player("Snow Leopard",4,4,4,4,0,2,0);
        snowCat.setImageID("snow_leopard");

        this.addPlayer(snowCat);
    }

    public int setTeamName(String name){
        try{
            this.teamName = name;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public String getTeamName(){return this.teamName;}

    public int setWins(int gamesWon){
        try{
            this.gameWins = gamesWon;
            return 1;
        }
        finally {
            return 0;
        }
    }

    public int getWins(){return this.gameWins;}

    public int setWins(String games_Wins)
    {
        try
        {
            this.gameWins=Integer.parseInt(games_Wins);
            return 1;
        }
        finally
        {
            return 0;
        }
    }

    public int setLoses(int gamesLost){
        try{
            this.gameLoses = gamesLost;
            return 1;
        }
        finally {
            return 0;
        }
    }
    public int getLoses(){
        return this.gameLoses;
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

    public int addPlayer(Player player){
        try{
            teamList.put(player.getPlayerName(), player);
            if (playerList.indexOf(player.getPlayerName()) == -1)
                playerList.add(player.getPlayerName());
            return 1;
        }
        finally {
            return 0;
        }
    }
    public Player getPlayer(String playerName){
        return teamList.get(playerName);
    }

    //gets the values for assists and goals
    public int updateTeamList(String playerName, int goals, int shotsOnGoal, int assists, int saves, int fouls, int yellowCards, int redCards ){
        if (teamList.get(playerName) == null)
            return 0;
        teamList.get(playerName).setGoals(goals);
        teamList.get(playerName).setShotsOnGoal(shotsOnGoal);
        teamList.get(playerName).setAssists(assists);
        teamList.get(playerName).setSaves(saves);
        teamList.get(playerName).setFouls(fouls);
        teamList.get(playerName).setYellowCards(yellowCards);
        teamList.get(playerName).setRedCards(redCards);
        return 1;
    }


}
