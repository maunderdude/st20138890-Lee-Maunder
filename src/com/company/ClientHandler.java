package com.company;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//ClientHandler class
class ClientHandler extends Thread
{
    // Declare variables

    final DataInputStream dis; //Declare dis as DataInputStream
    final DataOutputStream dos; //Declare dos as DataOutputStream
    final Socket s; //Declare s as a Socket
    private Object FileOutputStream;


    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

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

