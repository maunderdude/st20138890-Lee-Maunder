package com.company;

import java.io.*;
import java.net.*;

public class Client {

    // Variables
    private String client = "";
    private String server = "";

    public void startClient() {

        try {
            // Socket for connection on port
            Socket socket = new Socket("localhost", 7890);
            // Data input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));

            // While (not) server varibale equals "done" then loop
            while (!server.equals("done")) {
                server = dis.readUTF();

                // If server variable equals "done" then break
                if (server.equals("done")) {
                    System.out.println("End of the questions.\nPlease wait for all players to finish.");
                    System.out.println("--------------------------------------------------------------------");
                    break;
                }

                // If server variable equals "waiting" then print out message to player. continue.
                if (server.equals("waiting")) {
                    System.out.println("Please wait until all the players have joined!\n");
                    continue;
                }

                // Checking to see if server variable equals condition and then printing output to ask user for their details
                if (server.equals("firstname")) {
                    System.out.print("Welcome to the Game!\nEnter your first name: ");
                } else if (server.equals("surname")) {
                    System.out.print("Enter your surname: ");
                } else if (server.equals("age")) {
                    System.out.print("Enter your age: ");
                } else {
                    // Else statement to output request answer from user
                    System.out.println(server);
                    System.out.print("Enter your answer: ");
                }

                // Input from buffered reader
                client = readUserInput(buffRead);

                // Output
                dos.writeUTF(client);
                // Flush stream
                dos.flush();

                System.out.println();
            }

            // Input
            server = dis.readUTF();

            System.out.println(server);
            System.out.println();

            // Closing resources
            dis.close();
            dos.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // Setting a timeout timer for inactivity
    public String readUserInput(BufferedReader in) throws IOException {
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) < 60 * 1000
                && !in.ready()) {
        }
        String input;
        if (in.ready()) {
            input = in.readLine();
        } else {
            input = "timeout";
        }
        return input;
    }

    public static void main(String[] args) {
        new Client().startClient();
    }
}
