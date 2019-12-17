package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {

    // Variables
    String firstName;
    String surname;
    int age;
    int score;

    // Declaring socket, dataOutput and dataInput streams
    final DataInputStream dataIn;
    final DataOutputStream dataOut;
    final Socket sock;


    // Constructor
    public ClientHandler(Socket sock, DataInputStream dataIn, DataOutputStream dataOut){
        this.sock = sock;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
    }

    @Override
    public void run(){

        // Variables
        String received;
        String sendOut;

        while(true){

            try{
                dataOut.writeUTF("Please enter your first name:\nType 'exit' to exit game.");

                received = dataIn.readUTF();

                if(received.equals("exit")){
                    System.out.println("Player " + this.sock + " is exiting...");
                    System.out.println("Closing down connection...");
                    this.sock.close();
                    System.out.println("Connection closed");
                    break;
                }

                Player Player1 = new Player(firstName, surname, age, score);
                firstName = Player1.playerFirstName;
                surname = Player1.playerSurname;
                age = Player1.playerAge;
                score = Player1.playerScore;



            }catch(IOException e){
                e.printStackTrace();
            }
        }

        try{
            this.dataIn.close();
            this.dataOut.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
