package fr.unice.miage.td1.av;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Mini_Client {

    private Socket socket;
    private String nom;


    public Mini_Client(String addr, int port, String nom) throws IOException {
        socket = new Socket(addr, port);
        this.nom = nom;
        //ENVOI
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("My name is " + this.nom);
        //RETOUR
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        String message_distant = in.readLine();
        System.out.println(message_distant);

        for (int i = 0; i < 100; i++) {
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("DATA " + i);
        }


        socket.close();
    }

    public static void main(String[] args) throws IOException {
        Mini_Client mc = new Mini_Client(args[0], Integer.parseInt(args[1]), args[2]);
    }
}
