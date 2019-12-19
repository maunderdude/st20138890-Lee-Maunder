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
{   // There are no class variables declared
    //
    public static void main(String[] args) throws IOException
    {


        ServerSocket ss = new ServerSocket(7890);

        // running infinite loop to wait for client request
        // Request will be either to supply the date or current time
        //
        while (true) //infinite while loop
        {
            Socket s = null; //Declare a variable s of type socket and set it to null

            try
            {
                // socket object to receive incoming client requests
                s = ss.accept();

                System.out.println("A new client is connected : " + s);

                // obtaining input and out streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Assigning new thread for this client");

                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos); //declare a new thread t of type ClientHandler

                // Invoking the start() method
                t.start(); //Start the client handler

                System.out.println("Thread complete");

            } // End try part
            catch (Exception e){
                s.close();
                e.printStackTrace();
            } // End catch
        } // End while
    } // End Main
} // End Server Class