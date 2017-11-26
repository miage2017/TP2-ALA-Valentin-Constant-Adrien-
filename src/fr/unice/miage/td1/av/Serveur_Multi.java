package fr.unice.miage.td1.av;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Serveur_Multi {


    private ServerSocket socket;
    private Socket socketduserveur;

    public Serveur_Multi(int port) throws IOException {
        socket = new ServerSocket(port);
        System.out.println("Le serveur est à l'écoute du port " + socket.getLocalPort());
        this.run();
    }

    public void run() throws IOException {
        while (true) {
            socketduserveur = socket.accept();
            System.out.println("Un client vient de se connecter");
            serviceClient();
            System.out.println("Un client vient de se déconnecter");
            socketduserveur.close();
        }
    }

    public void serviceClient() throws IOException {
        int i = 0;
        String message_distant = "";
        while (message_distant != null && !message_distant.equals("FINISH")) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socketduserveur.getInputStream(), "UTF-8"));
            message_distant = in.readLine();
            System.out.println("Ligne " + i + ":" + message_distant);

            if (message_distant != null) {
                //ACCUSEE
                Matcher m = Pattern.compile("My name is ([\\w]*)").matcher(message_distant);
                if (m.matches()) {
                    PrintWriter out = new PrintWriter(socketduserveur.getOutputStream(), true);
                    out.println("Hello " + m.group(1));
                }
                i++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        if (isInteger(args[0]) && Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[0]) < 65535) {
            Serveur_Multi monServ = new Serveur_Multi(Integer.parseInt(args[0]));
        } else {
            System.out.println("Port invalide ! ");
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }

        return true;
    }
}
