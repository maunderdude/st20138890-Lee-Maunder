package com.company;

import java.net.*;
import java.util.Map;

public class Server {
    public static void main(String[] args) throws Exception {

        // Creating new object with xml file parameter
        domParser dp = new domParser(".idea/question2.xml");

        // Variables
        // Assigning map to dom parser object to get list of questions method
        Map<Integer, quizQuestions> questions = dp.getListOfQuestions();
        int players = dp.getNumOfPlayers();

        System.out.println("Players: " + players);

        // New client handler array to hold player connections
        ClientHandler[] playerThreads = new ClientHandler[players];

        try {
            // Server socket assigning port number
            ServerSocket servSock = new ServerSocket(7890);
            // Setting connection counter to 0
            int connectionCounter = 0;
            System.out.println("Server Started");
            while (true) {
                // socket object to receive incoming client requests
                Socket serverSock = servSock.accept();
                System.out.println("Player " + connectionCounter + " has joined the game.");

                // Passing new thread
                playerThreads[connectionCounter] = new ClientHandler(serverSock, connectionCounter, questions);
                // Incrementing  connection counter by 1 with each new connection
                connectionCounter++;
                // If counter equals max amount of players then break
                if (connectionCounter == players) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Start thread
        for (ClientHandler clientThread : playerThreads) {
            clientThread.start();
        }

        // Join thread
        for (ClientHandler clientThread : playerThreads) {
            clientThread.join();
        }

        // Variable assigned for declaring winner
        int max = 0;
        String player = null;

        // If player scores are greater than 0, assign variable and return player name.
        for (ClientHandler clientThread : playerThreads) {
            if (clientThread.getGameScore() > max) {
                max = clientThread.getGameScore();
                player = clientThread.getPlayerName();
            }
        }

        // Displaying winner
        for (ClientHandler clientThread : playerThreads) {
            clientThread.sleep(3000);
            clientThread.sendFinalMessage("*_*_*_*_*_*_* " + player + " has won! *_*_*_*_*_*_*");

        }

        System.out.println("Game over!");
    }
}