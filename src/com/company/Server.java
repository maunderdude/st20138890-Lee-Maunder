package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

//Server class
//
//
public class Server{
        public static void main(String[] args) throws IOException
    {

        // Creating new object with xml file parameter
        domParser dp = new domParser("question2.xml");

        // Variables
        // Assigning map to dom parser object to get list of questions method
        Map<Integer, quizQuestions> questions = dp.getListOFQuestions();
        int players = dp.getNumOfPlayers();

        System.out.println("Number of players: " + players);

        // Array for object to hold players
        ClientHandler[] playerThread = new ClientHandler[players];

        // Server socket assigning port number
        ServerSocket servSock = new ServerSocket(7890);

        //While loop waiting for client requests (User connects)
        while (true)
        {
            Socket sock = null; //Declare variable s of type socket and set it to null

            try
            {
                int connectionCounter = 0;

                System.out.println("Server has started");
                while(true){
                    // socket object to receive incoming client requests
                    sock = servSock.accept();
                    System.out.println("Player " + connectionCounter + " has joined the game");

                    // Passing new thread
                    playerThread[connectionCounter] = new ClientHandler(sock, connectionCounter, questions);

                    // Incrementing connection counter by 1
                    connectionCounter++;

                    // If connection counter equals players then break
                    if (connectionCounter == players) {
                        break;
                    }
                }
            } // End try
            catch (Exception e){
                sock.close();
                e.printStackTrace();
            } // End catch
        } // End while
    } // End Main
} // End Server Class
