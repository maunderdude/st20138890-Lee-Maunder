package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//Client class
public class Client
{
    // Test for object output
    // private static Object FileOutputStream;

    public static void main(String[] args) throws IOException

    {
        // Variables
        String firstName;
        String surname;
        String tempAge;
        int age;
        int score = 0;
        boolean bool = true;


        try
        {
            Scanner scn = new Scanner(System.in);

            // Getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            // Socket for connection on port
            Socket s = new Socket(ip, 7890);

            // Data input and output Streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());


            // In
            System.out.println(dis.readUTF());
            String toSend = scn.nextLine();
            //Out
            dos.writeUTF(toSend);
            firstName = toSend;


            //   TRYING TO FIGURE OUT LOOP FOR VALIDATION///////////////////////////
            if (toSend.matches("[a-zA-Z]*")) {

            }
            System.out.println("Your surname is: " + firstName.substring(0, 1).toUpperCase() + firstName.substring(1));
            Thread.sleep(1000);
            System.out.println("First name must be letters only");
            //   TRYING TO FIGURE OUT LOOP FOR VALIDATION ////////////////////////////


            //In
            System.out.println(dis.readUTF());
            toSend = scn.nextLine();
            //Out
            dos.writeUTF(toSend);
            surname = toSend;
            System.out.println("Your surname is: " + surname.substring(0,1).toUpperCase() + surname.substring(1));
            Thread.sleep(1000);

            // In
            System.out.println(dis.readUTF());
            toSend = scn.nextLine();
            //Out
            dos.writeUTF(toSend);
            tempAge = toSend;
            age = Integer.parseInt(tempAge);
            System.out.println("your age is " + age);
            Thread.sleep(1000);

            // New object for player
            Player newPlayer = new Player(firstName, surname, age, 0);
            newPlayer.greetPlayer();
            Thread.sleep(2000);




            // End while

            // In
            System.out.println(dis.readUTF());
            String enterKey = scn.nextLine();
            // Out
            dos.writeUTF(enterKey);
            // Read XML script once user presses enter



            // closing resources
        }catch(Exception e){
            e.printStackTrace();
        } // End try-catch
    } // End main
} // End Client Class