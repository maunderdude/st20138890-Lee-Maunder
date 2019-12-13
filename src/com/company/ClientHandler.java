package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {

    // Variables
    String playerName;

    String player1;
    int player1Age;

    String player2;
    int player2Age;

    final DataInputStream dataIn;
    final DataOutputStream dataOut;
    final Socket sock;


    // Constructor
    public ClientHandler(Socket sock, DataInputStream dataIn, DataOutputStream dataOut){
        this.sock = sock;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
    }
}
