package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        // Variables
        String playerName;
        String player1;
        String player2;

        // Server socket to specify port number '7890'
        ServerSocket servSock = new ServerSocket(7890);

        // While loop waiting for client connection request
        while (true) {

            // Declaring socket variable and assigning it to null
            Socket sock = null;

            try {
                // Accept incoming request from client
                sock = servSock.accept();
                System.out.println("A new player has joined : " + sock);

                /*
                // Accepting user name passing from client
                Scanner scan = new Scanner(sock.getInputStream());
                 */

                // Setting data input and output streams
                DataInputStream dataIn = new DataInputStream(sock.getInputStream());
                DataOutputStream dataOut = new DataOutputStream(sock.getOutputStream());

                System.out.println("Assigning new thread");

                // Creating new thread as new 'thread' of type clientHandler
                Thread thread = new ClientHandler(sock, dataIn, dataOut);

                // calling start method to start the client handler
                thread.start();
            } catch (Exception e) {

            }
        }

    }

}

