package fr.unice.miage.td1.av;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur_Jouet {

    private ServerSocket socket;
    private Socket socketduserveur;

    public Serveur_Jouet(int port) throws IOException {
        socket = new ServerSocket(port);
        System.out.println("Le serveur est à l'écoute du port " + socket.getLocalPort());
        socketduserveur = socket.accept();
        System.out.println("Un client vient de se connecter");
        int i = 0;
        String message_distant = "";
        while (message_distant != null) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socketduserveur.getInputStream()));
            message_distant = in.readLine();
            System.out.println("Ligne " + i + ":" + message_distant);
            i++;
        }

    }


    public static void main(String[] args) throws IOException {
        Serveur_Jouet monServ = new Serveur_Jouet(1200);
    }
}
