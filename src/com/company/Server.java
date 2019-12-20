package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//Server class
//
//
public class Server
{
    // Dom parser for testing
    // domParser dom = new domParser();

    public static void main(String[] args) throws IOException
    {

        // Test variable
        // int playerNum = 1;

        // Server socket assigning port number
        ServerSocket servSock = new ServerSocket(7890);

        //While loop waiting for client requests (User connects)
        while (true)
        {
            Socket sock = null; //Declare variable s of type socket and set it to null

            try
            {
                // socket object to receive incoming client requests
                sock = servSock.accept();

                System.out.println("A new client is connected : " + sock);

                // Data input and output streams
                DataInputStream dis = new DataInputStream(sock.getInputStream());
                DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

                System.out.println("Assigning new thread for this client");

                // Create a new thread object
                Thread t = new ClientHandler(sock, dis, dos); //declare a new thread t of type ClientHandler

                // Starting the client handler
                t.start();

                System.out.println("Thread complete");

            } // End try
            catch (Exception e){
                sock.close();
                e.printStackTrace();
            } // End catch
        } // End while
    } // End Main
} // End Server Class