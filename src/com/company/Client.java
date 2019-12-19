package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//Client class
public class Client extends Player
{
    // No class variables
    //


    public Client(String playerFirstName, String playerSurname, int playerAge, int playerScore) {
        super(playerFirstName, playerSurname, playerAge, playerScore);
    }



    public static void main(String[] args) throws IOException

    {

        String firstName;
        String surname;
        String tempAge;
        int age;
        int score = 0;
        boolean bool = true;

        try
        {
            Scanner scn = new Scanner(System.in);

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            // establish the connection with server port 5056
            Socket s = new Socket(ip, 7890);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // the following loop performs the exchange of
            // information between client and client handler
            while (bool)
            {
                System.out.println(dis.readUTF());
                String toSend = scn.nextLine();
                dos.writeUTF(toSend);

                firstName = toSend;
                System.out.println("Your first name is: " + firstName);
                Thread.sleep(1000);

                System.out.println(dis.readUTF());
                toSend = scn.nextLine();
                dos.writeUTF(toSend);

                surname = toSend;
                System.out.println("Your surname is: " + surname);
                Thread.sleep(1000);

                System.out.println(dis.readUTF());
                toSend = scn.nextLine();
                dos.writeUTF(toSend);

                tempAge = toSend;
                age = Integer.parseInt(tempAge);
                System.out.println("your age is " + age);
                Thread.sleep(1000);

                Player newPlayer = new Player(firstName, surname, age, 0);

                newPlayer.greetPlayer();

                bool = false;

                break;

            } // End while

            System.out.println(dis.readUTF());
            String answer = scn.nextLine();
            dos.writeUTF(answer);
            if(answer.equals("1")){
                score = score + 1;
                System.out.println("Your score is: " + score);
            }
            else{
                System.out.println("next question");
            }

            // closing resources
        }catch(Exception e){
            e.printStackTrace();
        } // End try-catch
    } // End main
} // End Client Class
