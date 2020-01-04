package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ClientHandler extends Thread {
    // Variables
    private Socket s;
    private int playerNumber;
    private int gameScore;
    private String firstName;
    private String surname;
    private String age;
    int i = 0;

    private Map<Integer, quizQuestions> listOfQuestions;

    // Data input and output streams
    DataOutputStream dos;
    DataInputStream dis;

    // Constructor
    ClientHandler(Socket s, int counter, Map<Integer, quizQuestions> listOfQuestions) {
        this.s = s;
        playerNumber = counter;
        this.gameScore = 0;

        this.listOfQuestions = listOfQuestions;

        try {
            // Input and output streams
            dis = new DataInputStream(this.s.getInputStream());
            dos = new DataOutputStream(this.s.getOutputStream());
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

            // Assigning variable firstname to user input
            firstName = received;

            // Output
            dos.writeUTF("surname");
            // Flush stream
            dos.flush();

            // Input
            received = dis.readUTF();

            // Assigning variable surname to user input
            surname = received;

            // Output
            dos.writeUTF("age");
            // Flush stream
            dos.flush();

            // Input
            received = dis.readUTF();

            // Assigning variable age to user input
            age = received;

            System.out.println("Player " + firstName.substring(0, 1).toUpperCase() + firstName.substring(1) + " " + surname.substring(0, 1).toUpperCase() + surname.substring(1) + " is connected.");

            // Output
            dos.writeUTF("waiting");
            // Flush stream
            dos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String clientMessage = "";

            // Question to map
            for (Map.Entry<Integer, quizQuestions> questionEntry : listOfQuestions.entrySet()) {
                quizQuestions question = questionEntry.getValue();

                String optionList = "";

                // answer to map
                for (Map.Entry<Integer, String> option : question.getOptions().entrySet()) {
                    optionList += String.format("\t%d.%s\n", option.getKey(), option.getValue());
                }

                // Output question and answers
                dos.writeUTF(String.format("%d. %s\n%s", question.getQuestionId(), question.getText(), optionList));
                dos.flush();

                // Input
                clientMessage = dis.readUTF();

                // Timeout check
                if (!clientMessage.equals("timeout")) {
                    if (clientMessage.equals(String.valueOf(question.getAnswerId()))) {
                        gameScore++;
                    }
                }

            }


            // output
            dos.writeUTF("done");
            //Flush stream
            dos.flush();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Player " + playerNumber + " has finished answering.");
        }
    }

    // Get score
    public int getGameScore() {
        return gameScore;
    }

    // Get player name
    public String getPlayerName() {
        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1) + " " + surname.substring(0, 1).toUpperCase() + surname.substring(1);
    }

    // Closing resources with "print" message
    public void sendFinalMessage(String message) {
        try {
            dos.writeUTF(message);
            dos.flush();

            dis.close();
            dos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
