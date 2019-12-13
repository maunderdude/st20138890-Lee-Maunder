package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {

        // Variables
        String playerName;

        // Creating new scanner for input
        Scanner scan = new Scanner(System.in);


        // Socket with parameters - 'ip' and 'port number'
        Socket sock = new Socket("localhost", 7890);

        // Scanner to get input stream from socket (server)
        Scanner scan1 = new Scanner(sock.getInputStream());

        System.out.println("Hello./\nPlease enter your name: ");

        // Assigning user input(name) to variable
        playerName = scan.nextLine();

        // Print stream object to pass name to server
        PrintStream p = new PrintStream(sock.getOutputStream());

        // Passing user name
        p.println(playerName);

                /*  Might need this to return name from server
                playerName = scan1.nextLine();
                 */

        System.out.println("Welcome " + playerName + "!\nGet ready for the quiz.");


        // exception handling
    }


}

