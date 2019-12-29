package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Map;

//ClientHandler class
public class ClientHandler extends Thread {
    // Declare variables
    private Socket sock;
    private String firstName;
    private String surname;
    private String age;
    private int gameScore;
    private int playerNumber;
    private DataInputStream dis; //Declare dis as DataInputStream
    private DataOutputStream dos; //Declare dos as DataOutputStream

    private Map<Integer, quizQuestions> listOfQuestions;

    int i = 0;

    // Constructor
    ClientHandler(Socket s, int counter, Map<Integer, quizQuestions> listOfQuestions) {
        sock = s;
        playerNumber = counter;
        this.gameScore = 0;

        this.listOfQuestions = listOfQuestions;

        // Input and output streams
        try {
            dis = new DataInputStream(sock.getInputStream());
            dos = new DataOutputStream(sock.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            // Output
            dos.writeUTF("firstname");
            // Flush stream
            dos.flush();

            // Input
            String received = dis.readUTF();

            // Assigning variable first name to user input for first name
            firstName = received;


            // Output
            dos.writeUTF("surname");
            // Flush stream
            dos.flush();

            // Input
            received = dis.readUTF();

            // Assigning variable to user input for surname
            surname = received;

            // output
            dos.writeUTF("age");
            // Flush stream
            dos.flush();

            // Input
            received = dis.readUTF();

            // Assigning variable age to input for age
            age = received;

            System.out.println("Player " + firstName.substring(0, 1).toUpperCase() + firstName.substring(1) + " " + surname.substring(0, 1).toUpperCase() + surname.substring(1) + " is connected.");

            // Output to allow all players to connect
            dos.writeUTF("waiting");
            // Flush stream
            dos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getScore() {
        return gameScore;
    }


    public String getPlayerName() {
        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1) + " " + surname.substring(0, 1).toUpperCase() + surname.substring(1);
    }


    public void sendFinalMessage(String message) {
        try {
            dos.writeUTF(message);
            dos.flush();

            dis.close();
            dos.close();
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
