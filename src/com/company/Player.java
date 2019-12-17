package com.company;

public class Player{

    // Variables

    String playerFirstName;
    String playerSurname;
    int playerAge;
    int playerScore = 0;

    public Player(String firstName, String surname, int age, int score){
        playerFirstName = firstName;
        playerSurname = surname;
        playerAge = age;
        playerScore = score;
    }


    //////////////////////////////////////////////////
    /////////////// Getters and setters///////////////
    //////////////////////////////////////////////////
    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
    ////////////////////////////////////////////////
    ///////////End getters and setters//////////////
    ////////////////////////////////////////////////


    // Welcome message with name method
    public void welcomeMessage(){
        System.out.println("Welcome " + playerFirstName + " " + playerSurname);
    }



    // Give score method
    public void displayScore(){
        System.out.println("Your score is: " + playerScore);

    }


}
