package com.company;

import java.io.*;
import java.net.Socket;

//ClientHandler class
class ClientHandler extends Thread
{
    // Declare variables
    private Socket sock;
    private String firstName;
    private String surname;
    private String age;
    private int gameScore;
    private int playerNumber;
    final DataInputStream dis; //Declare dis as DataInputStream
    final DataOutputStream dos; //Declare dos as DataOutputStream


    // Constructor
    public ClientHandler(Socket s, int counter, domParser)
    {
        sock = s;
        playerNumber = counter;
        this.gameScore = 0;

        // NEED TO INCLUDE MAP

        // NEED TO INCLUDE DATA INPUT AND OUTPUT STREAMS FOR COMMUNICATION

    @Override
    public void run()
    {
        //Declare two strings for receive and return information
        String received;
        String toReturn;
        int intReceived;


        //Infinite loop setup
        //
        while (true)
        {
            try {


                while(true) {
                    // Ask for user First Name
                    dos.writeUTF("---------------------------------------------------\nPlease enter your First Name: ");

                    break;
                }

                // Receive the answer from client
                received = dis.readUTF();

                // Ask for user Surname
                dos.writeUTF("---------------------------------------------------\nPlease enter your Surname; ");

                // Receive the answer from client
                received = dis.readUTF();

                // Ask for user Age
                dos.writeUTF("---------------------------------------------------\nPlease enter your Age; ");

                // Receive the answer from client
                received = dis.readUTF();

                // Press enter to start quiz
                dos.writeUTF("---------------------------------------------------\nPress enter to start quiz; ");

                // Receive the answer from client
                received = dis.readUTF();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        // closing resources



    }
}