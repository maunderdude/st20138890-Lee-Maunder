package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//Server class
//
//
public class Server{
        public static void main(String[] args) throws IOException
    {

        // Creating new object
        domParser domParser = new domParser("question.xml");

        // Variables
        int players = domParser.getNumOfPlayers();

        System.out.println("Number of players: " + players);

        // Creating new client handler object
        ClientHandler[] playerThread = new ClientHandler(players);

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
                    playerThread[connectionCounter] = new ClientHandler(sock, connectionCounter,);

                    // Incrementing connection counter b 1
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
