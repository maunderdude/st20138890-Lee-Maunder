package com.company;

import org.w3c.dom.NodeList;

public class Player extends Thread {

    // Variables

    String playerFirstName;
    String playerSurname;
    int playerAge;
    int playerScore = 0;

    public Player(String playerFirstName, String playerSurname, int playerAge, int playerScore) {
        this.playerFirstName = playerFirstName;
        this.playerSurname = playerSurname;
        this.playerAge = playerAge;
        this.playerScore = playerScore;

    }
        //////////////////////////////////////////////////
        /////////////// Getters and setters///////////////
        //////////////////////////////////////////////////
        public String getPlayerFirstName () {
            return playerFirstName;
        }

        public void setPlayerFirstName (String playerFirstName){
            this.playerFirstName = playerFirstName;
        }

        public String getPlayerSurname () {
            return playerSurname;
        }

        public void setPlayerSurname (String playerSurname){
            this.playerSurname = playerSurname;
        }

        public int getPlayerAge () {
            return playerAge;
        }

        public void setPlayerAge ( int playerAge){
            this.playerAge = playerAge;
        }

        public int getPlayerScore () {
            return playerScore;
        }

        public void setPlayerScore ( int playerScore){
            this.playerScore = playerScore;
        }
        ////////////////////////////////////////////////
        ///////////End getters and setters//////////////
        ////////////////////////////////////////////////


    public void greetPlayer(){
        System.out.println("------------------------------------------------------------\nWelcome " +
                playerFirstName.substring(0,1).toUpperCase() + playerFirstName.substring(1) + " " + playerSurname.substring(0,1).toUpperCase() + playerSurname.substring(1) + "!");
    }


    }
























