package com.company;

import java.io.*;
import java.net.Socket;

//Client class
public class Client {

    // Variables
    public String client = "";
    public String server = "";

    public void start() {
        try {

            // Socket for connection on port
            Socket s = new Socket("localhost", 7890);

            // Data input and output Streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));

            // While loop
            // While (not) server variable equals "done" then loop
            while (!server.equals("done")) {
                // Assigning server variable to readUTF (in)
                server = dis.readUTF();

                // If server variable equals "done" then break
                if (server.equals("done")) {
                    System.out.println("End of the questions.\n");
                    break;
                }

                // If server variable equals "waiting" then print out message to player. continue.
                if (server.equals("waiting")) {
                    System.out.println("Please wait until all of the players have joined...\n");
                    continue;
                }

                // Checking to see if server variable equals condition and then printing output to ask user for their details
                if (server.equals("firstname")) {
                    System.out.print("Welcome to the Game!\nPlease enter your first name: ");
                } else if (server.equals("surname")) {
                    System.out.print("Enter your surname: ");
                } else if (server.equals("age")) {
                    System.out.print("Enter your age: ");
                    //
                } else {
                    // Else statement to output request answer from user
                    System.out.println(server);
                    System.out.print("Enter your answer: ");
                }

                client = readUserInput(buffRead);

                dos.writeUTF(client);
                dos.flush();

                System.out.println();
            }

            server = dis.readUTF();

            System.out.println(server);
            System.out.println();

            // Closing resources
            dis.close();
            dos.close();
            s.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    private String readUserInput(BufferedReader in)throws IOException {
        String input;
        input = in.readLine();
        return input;
    }

    // Start client
    public static void main(String[] args) {
        new Client().start();
    }
}


