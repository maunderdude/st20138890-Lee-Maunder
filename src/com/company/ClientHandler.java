package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
        String toreturn;
        int intReceived;

        //Infinite loop setup
        //
        while (true)
        {
            try {

                // Ask user what he wants

                dos.writeUTF("---------------------------------------------------\nPlease enter your first name: ");

                // receive the answer from client
                received = dis.readUTF();


                dos.writeUTF("---------------------------------------------------\nPlease enter your surname; ");

                // receive the answer from client
                received = dis.readUTF();

                dos.writeUTF("---------------------------------------------------\nPlease enter your age; ");

                // receive the answer from client
                received = dis.readUTF();

                dos.writeUTF("---------------------------------------------------\n1: Right\n2: Wrong; ");

                // receive the answer from client
                received = dis.readUTF();




            } catch (IOException e) {
                e.printStackTrace();
            }
        }



            // closing resources



    }
}

