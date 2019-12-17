package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.server.ServerNotActiveException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {

        // Variables
        String playerName;

        try {
            // Creating new scanner for input
            Scanner scan = new Scanner(System.in);

            // Socket with parameters - 'ip' and 'port number'
            Socket sock = new Socket("localhost", 7890);

            // Setting data input and output streams
            DataInputStream dataIn = new DataInputStream(sock.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(sock.getOutputStream());

            while (true) {
                System.out.println(dataIn.readUTF());
                String sendOut = scan.nextLine();
                dataOut.writeUTF(sendOut);

                if (sendOut.equals("Exit")) {
                    System.out.println("Closing connection " + sock);
                    sock.close();
                    System.out.println("Connection closed");
                    break;
                }

                String received = dataIn.readUTF();
                System.out.println(received);
            }

            scan.close();
            dataIn.close();
            dataOut.close();
        } catch(Exception e){
            e.printStackTrace();
        }





        /*
        // Scanner to get input stream from socket (server)
        Scanner scan1 = new Scanner(sock.getInputStream());

        System.out.println("Hello./\nPlease enter your name: ");

        // Assigning user input(name) to variable
        playerName = scan.nextLine();

        // Print stream object to pass name to server
        PrintStream p = new PrintStream(sock.getOutputStream());

        // Passing user name
        p.println(playerName);

         */

                /*  Might need this to return name from server
                playerName = scan1.nextLine();
                 */

       // System.out.println("Welcome " + playerName + "!\nGet ready for the quiz.");





        // exception handling
    }


}

